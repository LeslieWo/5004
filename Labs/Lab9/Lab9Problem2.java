import java.util.ArrayList;
import java.util.List;

/**
 * CS5004 Spring 2026 - Lab 9 Problem 2
 * Game Character Creation System
 *
 * Patterns used:
 * - Builder: CharacterBuilder
 * - Prototype: clone() in GameCharacter subclasses
 * - Decorator: WeaponDecorator, ArmorDecorator
 * - Factory Method: CharacterFactory
 */
public class Lab9Problem2 {

    public static void main(String[] args) {
        CharacterManager.runDemo();
    }
}

abstract class GameCharacter implements Cloneable {
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;

    public GameCharacter(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public abstract GameCharacter clone();
    public abstract String getDescription();

    public String getStats() {
        return "Name=" + name
                + ", Health=" + health
                + ", Attack=" + attack
                + ", Defense=" + defense;
    }
}

class Warrior extends GameCharacter {
    public Warrior(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
    }

    @Override
    public GameCharacter clone() {
        return new Warrior(this.name, this.health, this.attack, this.defense);
    }

    @Override
    public String getDescription() {
        return "Warrior";
    }
}

class Mage extends GameCharacter {
    public Mage(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
    }

    @Override
    public GameCharacter clone() {
        return new Mage(this.name, this.health, this.attack, this.defense);
    }

    @Override
    public String getDescription() {
        return "Mage";
    }
}

class Archer extends GameCharacter {
    public Archer(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
    }

    @Override
    public GameCharacter clone() {
        return new Archer(this.name, this.health, this.attack, this.defense);
    }

    @Override
    public String getDescription() {
        return "Archer";
    }
}

interface Equipment {
    int getAttackBonus();
    int getDefenseBonus();
    String getDescription();
}

class Weapon implements Equipment {
    private final String description;
    private final int attackBonus;

    public Weapon(String description, int attackBonus) {
        this.description = description;
        this.attackBonus = attackBonus;
    }

    @Override
    public int getAttackBonus() {
        return attackBonus;
    }

    @Override
    public int getDefenseBonus() {
        return 0;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

class Armor implements Equipment {
    private final String description;
    private final int defenseBonus;

    public Armor(String description, int defenseBonus) {
        this.description = description;
        this.defenseBonus = defenseBonus;
    }

    @Override
    public int getAttackBonus() {
        return 0;
    }

    @Override
    public int getDefenseBonus() {
        return defenseBonus;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

// Builder pattern
class CharacterBuilder {
    private String type = "warrior";
    private String name = "Unnamed";
    private int health = 100;
    private int attack = 10;
    private int defense = 10;
    private final List<Equipment> equipmentList = new ArrayList<>();

    public CharacterBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public CharacterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CharacterBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    public CharacterBuilder setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    public CharacterBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    public CharacterBuilder addEquipment(Equipment equipment) {
        equipmentList.add(equipment);
        return this;
    }

    public GameCharacter build() {
        GameCharacter character;
        switch (type.toLowerCase()) {
            case "mage":
                character = new Mage(name, health, attack, defense);
                break;
            case "archer":
                character = new Archer(name, health, attack, defense);
                break;
            case "warrior":
            default:
                character = new Warrior(name, health, attack, defense);
                break;
        }

        for (Equipment equipment : equipmentList) {
            if (equipment.getAttackBonus() > 0) {
                character = new WeaponDecorator(character, equipment);
            } else if (equipment.getDefenseBonus() > 0) {
                character = new ArmorDecorator(character, equipment);
            }
        }
        return character;
    }
}

// Decorator pattern
abstract class CharacterDecorator extends GameCharacter {
    protected final GameCharacter wrappedCharacter;

    public CharacterDecorator(GameCharacter wrappedCharacter) {
        super(wrappedCharacter.getName(),
                wrappedCharacter.getHealth(),
                wrappedCharacter.getAttack(),
                wrappedCharacter.getDefense());
        this.wrappedCharacter = wrappedCharacter;
    }

    @Override
    public void setName(String name) {
        wrappedCharacter.setName(name);
    }

    @Override
    public void setHealth(int health) {
        wrappedCharacter.setHealth(health);
    }

    @Override
    public void setAttack(int attack) {
        wrappedCharacter.setAttack(attack);
    }

    @Override
    public void setDefense(int defense) {
        wrappedCharacter.setDefense(defense);
    }
}

class WeaponDecorator extends CharacterDecorator {
    private final Equipment weapon;

    public WeaponDecorator(GameCharacter wrappedCharacter, Equipment weapon) {
        super(wrappedCharacter);
        this.weapon = weapon;
    }

    @Override
    public int getAttack() {
        return wrappedCharacter.getAttack() + weapon.getAttackBonus();
    }

    @Override
    public int getDefense() {
        return wrappedCharacter.getDefense() + weapon.getDefenseBonus();
    }

    @Override
    public int getHealth() {
        return wrappedCharacter.getHealth();
    }

    @Override
    public String getName() {
        return wrappedCharacter.getName();
    }

    @Override
    public GameCharacter clone() {
        return new WeaponDecorator(wrappedCharacter.clone(), weapon);
    }

    @Override
    public String getDescription() {
        return wrappedCharacter.getDescription() + " with " + weapon.getDescription();
    }

    @Override
    public String getStats() {
        return "Name=" + getName()
                + ", Health=" + getHealth()
                + ", Attack=" + getAttack()
                + ", Defense=" + getDefense();
    }
}

class ArmorDecorator extends CharacterDecorator {
    private final Equipment armor;

    public ArmorDecorator(GameCharacter wrappedCharacter, Equipment armor) {
        super(wrappedCharacter);
        this.armor = armor;
    }

    @Override
    public int getAttack() {
        return wrappedCharacter.getAttack() + armor.getAttackBonus();
    }

    @Override
    public int getDefense() {
        return wrappedCharacter.getDefense() + armor.getDefenseBonus();
    }

    @Override
    public int getHealth() {
        return wrappedCharacter.getHealth();
    }

    @Override
    public String getName() {
        return wrappedCharacter.getName();
    }

    @Override
    public GameCharacter clone() {
        return new ArmorDecorator(wrappedCharacter.clone(), armor);
    }

    @Override
    public String getDescription() {
        return wrappedCharacter.getDescription() + " wearing " + armor.getDescription();
    }

    @Override
    public String getStats() {
        return "Name=" + getName()
                + ", Health=" + getHealth()
                + ", Attack=" + getAttack()
                + ", Defense=" + getDefense();
    }
}

// Factory Method pattern
class CharacterFactory {
    public static GameCharacter createCharacter(String role, String name) {
        switch (role.toLowerCase()) {
            case "tank":
                return new Warrior(name, 180, 20, 35);
            case "dps":
                return new Archer(name, 110, 35, 12);
            case "support":
                return new Mage(name, 100, 22, 18);
            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }
    }
}

class CharacterManager {
    public static void runDemo() {
        System.out.println("=== Problem 2: Game Character Creation System ===");

        // Factory method examples
        GameCharacter tank = CharacterFactory.createCharacter("tank", "Brutus");
        GameCharacter dps = CharacterFactory.createCharacter("dps", "Sylva");
        GameCharacter support = CharacterFactory.createCharacter("support", "Lyra");

        printCharacter("Factory Tank", tank);
        printCharacter("Factory DPS", dps);
        printCharacter("Factory Support", support);

        // Builder example
        GameCharacter customCharacter = new CharacterBuilder()
                .setType("mage")
                .setName("Ezra")
                .setHealth(120)
                .setAttack(28)
                .setDefense(14)
                .addEquipment(new Weapon("Fire Staff", 8))
                .addEquipment(new Armor("Magic Robe", 5))
                .build();

        printCharacter("\nBuilt Character", customCharacter);

        // Prototype example
        GameCharacter clonedCharacter = customCharacter.clone();
        clonedCharacter.setName("Ezra Clone");
        clonedCharacter.setHealth(130);

        printCharacter("\nCloned Character", clonedCharacter);

        // Decorator examples
        GameCharacter upgradedTank = new ArmorDecorator(
                new WeaponDecorator(tank.clone(), new Weapon("Great Sword", 12)),
                new Armor("Steel Armor", 10)
        );

        printCharacter("\nDecorated Character", upgradedTank);
    }

    private static void printCharacter(String label, GameCharacter character) {
        System.out.println(label + ":");
        System.out.println("  Description: " + character.getDescription());
        System.out.println("  Stats: " + character.getStats());
    }
}
