package kg.geeks.game.players;

public class Berserk extends Hero {
    private int blockedDamage;
    private int healthBerserk;

    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.BLOCK_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        blockedDamage = boss.getDamage() / 3;
        boss.setHealth(boss.getHealth()-blockedDamage);
        System.out.println("Berserk reflected part of the damage: " + this.getDamage());
    }

    public void setBlockedDamage(int blockedDamage) {
        this.blockedDamage = blockedDamage;
    }
}
