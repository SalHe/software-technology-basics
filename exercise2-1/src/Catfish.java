public class Catfish {
    private int column = 1;
    private int energyLevel = 10;
    private static final int TIRED_ENERGY_LEVEL = 3;

    public int getColumn() {
        // ADD YOUR CODE HERE
        //getColumn() should return the value of the column attribute


        //END
        return column;
    }

    public void swimRight() {
        // ADD YOUR CODE HERE
        //swimRight() should increment the value of the column attribute 
        //and decrement the value of energyLevel attribute 
        //if the new value of the column attribute will be less than or equal to 10. 


        //END

        // 这里energyLevel给定的初值不太合理：
        // 总共的空格有10列，小鱼最开始在1列，有十点精力。
        // 所以小鱼耗完经历可以去到11列，显然越界了。
        if (energyLevel > 0 && column < 10) {
            energyLevel--;
            column++;
        }
    }

    public String getImage() {

        // ADD YOUR CODE HERE
        //getImage() should return the image filename that represents the catfish. 
        //The image of a tired catfish is "CatFish-tired.gif". 
        //The image of a catfish that is not tired is "CatFish.gif". 


        //END
        if (energyLevel < TIRED_ENERGY_LEVEL) {
            return "resource/img/CatFish-tired.gif";
        } else {
            return "resource/img/CatFish.gif";
        }
    }
}
