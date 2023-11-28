public class Main {
    public static void main(String[] args){
        //create players & equipments//
        Player p1 = new Player("player1");
        Player p2 = new Player("player2");
        Sword sword1 = new Sword("sword1",5);
        Sword sword2 = new Sword("sword2",3);
        Shield shield1 = new Shield("shield1",3);
        Shield shield2 = new Shield("shield1",4);

        //equipped Sword & Shield//
        p1.equipSword(sword1);
        p1.equipShield(shield1);
        p2.equipSword(sword2);
        p2.equipShield(shield2);

        //Upgrade equipments//
        sword1.SwordUpGrade();
        shield1.ShieldUpGrade();

        //battle phrase//
        p1.attack(p2);
        p1.attack(p2);
        p2.attack(p1);
        p1.attack(p2);
        p1.attack(p2);
    }
}

class Player{
    String name;
    private int maxHP = 20,hp = 15,lv = 1,maxMP = 10,mana = 10,exp = 0;
    private int atk = 3,def = 0,spd = 5;
    public Player(String name){
        this.name = name;
        System.out.println("---------------------------------------");
        System.out.println(name+" hp = "+hp + " mana = "+mana);

    }
    public void equipSword(Sword swd){
        atk = atk + swd.atk;
        spd = atk + swd.spd;
        System.out.println("---------------------------------------");
        System.out.println(name+" atk = "+ atk );
    }

    public void equipShield(Shield shield){
        def = def + shield.def;
        spd = spd + shield.spd;
        System.out.println("---------------------------------------");
        System.out.println(name+" def = "+ def );
    }

    public void attack(Player enemy){

        mana = mana - 1;
        //dmg = player's atk - enemy's def
        enemy.hp = enemy.hp - (atk - enemy.def);
        if(enemy.hp>=1){
            System.out.println("---------------------------------------");
            System.out.println(name+" attack "+enemy.name);
            System.out.println(name+"'s mana = "+mana);
            System.out.println(enemy.name+"'s hp = "+enemy.hp);
        }else {

            System.out.println("---------------------------------------");
            System.out.println(enemy.name+" is dead");
            System.out.println(name+" received 10 exp!");
            exp = exp +10;
            if(this.exp >= 30){

                lv = lv+1;
                lvUp(this);
                System.out.println(name+" has reached lv "+lv);
                System.out.println(name+" hp =  "+ maxHP+" mana =  "+ maxMP);
            }
        }

    }

    public void lvUp(Player player){
        player.maxHP = player.maxHP + 3;
        player.maxMP = player.maxMP + 3;
        player.hp = player.maxHP;
        player.mana = player.maxMP;
    }
}
class Sword{
    String name;
    int atk ;
    int spd = -1;
    private int lv = 1;
    public Sword(String name , int atk){
        this.name = name;
        this.atk = atk;
    }
    public void SwordUpGrade(){
        lv = lv+1;
        atk = atk + lv;
        System.out.println("---------------------------------------");
        System.out.println(name+" lv "+lv+ " atk = "+ atk);
    }
}
class Shield {
    String name;
    int def;
    int spd = -2;
    int lv = 1;
    public Shield(String name , int def){
        this.name = name;
        this.def = def;
    }
    public void ShieldUpGrade(){
        lv = lv+1;
        def = def + lv;
        System.out.println("---------------------------------------");
        System.out.println(name+" lv "+lv+ " def = "+ def);
    }
}

