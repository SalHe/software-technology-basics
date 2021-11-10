import java.util.Objects;

public class Catfish extends LivingBeing {

    /**
     * The catfish is born "alive".
     * Then it dies, becoming a corpse.
     */
    private String ALIVE = "alive";

    /**
     * The catfish is born "alive".
     * Then it dies, becoming a "dead" corpse.
     */
    private String DEAD = "dead";

    /**
     * Energy needed to swim in a block of time.
     */
    private int ENERGY_TO_SWIM = 2;

    /**
     * Row-wise location of the catfish
     */
    private int row;

    /**
     * Column-wise location of the catfish
     */
    private int column;

    /**
     * Image of the catfish - is really a filename
     */
    private String imageFileName;

    /**
     * Is the catfish dead or alive?
     */
    private String deadOrAlive;

    /**
     * Age expressed as blocks of time lived
     */
    private int age;

    private int energy;

    /**
     * The simulation to which this catfish belongs.
     * This is needed so the catfish can send a message
     * to simulation.
     */
    private Simulation simulation;

    public Catfish(int paramInt1, int paramInt2, Simulation paramSimulation) {
        this.simulation = paramSimulation;
        this.deadOrAlive = this.ALIVE;
        this.age = 0;
        this.energy = 10;
        this.imageFileName = "resource/img/CatFish-right.gif";//This image is CatFish-right.gif
        this.row = paramInt1;
        this.column = paramInt2;
    }

    /**
     * Get the row at which the catfish is located
     *
     * @return - the row of the catfish's location.
     */
    public int getRow() {
        return row;
    }

    /**
     * Get the column at which the catfish is located
     *
     * @return - the column of the catfish's location.
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * get filename of catfish image
     *
     * @return filename of Catfish image
     */
    public String getImage() {
        return this.imageFileName;
    }

    /**
     * Get the catfish's age
     *
     * @return the age of the catfish expressed in blocks of time
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Get the energy of the catfish
     *
     * @return current energy level of the catfish
     */
    public int getEnergy() {
        return this.energy;
    }

    /**
     * Die: The Catfish dies.
     */
    public void die() {
        this.deadOrAlive = this.DEAD;
    }

    /**
     * Is the catfish dead?
     *
     * @return <code>true</code> if dead. <code>false</code>, otherwise.
     */
    public boolean isDead() {
        return Objects.equals(this.deadOrAlive, this.DEAD);
    }

    /**
     * Swim to a new location if possible.
     * Consumes some energy.
     */
    private void swimIfPossible() {
        // Please complete this method.(~1line)


        // Consume ENERGY_TO_SWIM units of energy to swim.
        energy -= ENERGY_TO_SWIM;

        // Check if there is any energy left after consumption(~2/3lines)
        if (energy <= 0) {
            return;
        }

        //END

        //Please Complete Here(~2lines)
    	/*Swim at random in one of four directions.
		Assign a random row location for the Catfish as follows.  
		(1) Send the "getRand" message to the "simulation" object to get a random number generator. 
		The "simulation" object is initialized in the constructor above.
		(2) Send the "nextInt" message to the random number generator obtained above. 
		The "nextInt" behavior returns an integer between 0(inclusive) and the integer specified as a parameter(exclusive). 
		Thus, specifiying a value of 10 to the "nextInt" behavior will return an integer between 0 and 9.
		Similarly, assign a random column location for the catfish
		*/


        //END
        int direction = simulation.getRand().nextInt(4);
        // 上右下左
        final int[] dx = {0, 1, 0, -1};
        final int[] dy = {-1, 0, 1, 0};
        row += dy[direction];
        column += dx[direction];
        // 防止小鱼游出“池塘”
        row = Math.max(row, simulation.getFirstRow());
        row = Math.min(row, simulation.getLastRow());
        column = Math.max(column, simulation.getFirstColumn());
        column = Math.min(column, simulation.getLastColumn());
    }

    /**
     * Catfish lives its life. Dies if it has no energy left.
     */
    public void liveALittle() {
        // Please complete this method.(5~6lines)
        /*If there is no energy left, send a "die" message to this catfish
        Increment the age of the Catfish by 1
        Try to swim by sending a "swimIfPossible" message
        */


        //END
        if (energy <= 0) {
            age++;
            die();
        }
        swimIfPossible();
    }
}
