package task3;

import task3.Line.Position;

public class Monster implements Linable,Comparable<Monster>{
        
    public static int ROW = 8;
    public static int COL = 8;
    public static int MonsterNum = ROW * COL;
    Color color;
    public static Monster monsters[];
    public static Matrix getMonsters(int row,int col){
        Monster.ROW = row;
        Monster.COL = col;
        Monster.MonsterNum = Monster.ROW * Monster.COL;
        Matrix line = new Matrix(MonsterNum);
        Color[] colors = ColorUtil.getRandomColors();
        monsters = new Monster[MonsterNum];
        for(int i = 0;i<MonsterNum;i++){
            monsters[i] = new Monster(colors[i]);
            line.put(monsters[i],i);
        }
        return line;
    }
    
    Monster(Color color){
        this.color = color;
    }
    @Override
    public int compareTo(Monster o) {
        return color.compareTo(o.color);
    }
    private Position position;
    
    public String toString() {
        return "\033[48;2;" + color.r + ";" + color.g + ";" + color.b + ";38;2;0;0;0m   " + "  \033[0m";
    }
    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }
    public void swapPosition(Monster another) {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }
    @Override
    public int getValue(){
        return rank();
    }
    public int rank(){
        return color.rank();
    }
    public static Monster getMonsterByRank(int rank) {

        for (Monster monster : Monster.monsters) {
            if (monster.rank() == rank) {
                return monster;
            }
        }
        return null;

    }
}
