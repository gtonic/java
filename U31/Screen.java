import java.util.Scanner; 

/**
 * Abstracts a Screen with a Field of Rows and Columns (ROWS * COLS),
 * a Menu-Area (right of the Field) and an User-Input-Area (below the Menu-Area).
 */
public class Screen {

    /**
     * Number of Columns in the 'Field'.
     */
    public final int COLS; 
    
    /**
     * Number of Rows in the 'Field'.
     */
    public final int ROWS;
    
    /**
     * Number of Colums/Rows of the Border of the 'Field'.
     */
    private final int BORDER = 3;
    
    /**
     * Distance from Border to Menu.
     */ 
    private final int MENU_X_OFFSET = 10;
    
    /**
     * Total X-Length of the Screen.
     */ 
    private final int X_LENGTH = 79;

    /**
     * Total two-dimensional Char-Array which represents the whole Screen.
     * First-Dimension  : Y-Direction (Rows)
     * Second-Dimension : X-Direction (Columns)
     */ 
    private char[][] mScreen;
    
    private Scanner mScanner;
    

    /**
     * Initializes the whole Screen (incl. the Field of Rows and Columns with 
     * the Borders).
     * @param pCols The Number of Columns in the Field.
     * @param pRows The Number of Rows in the Field.
     */
    public Screen(int pCols, int pRows) {
    	//Spalten werden mit Eingabe pCols aus Main initialisiert
    	COLS= pCols;
    	//Reihen werden mit Eingabe pRows aus Main initialisiert
        ROWS= pRows;
        //mScreen wird mit nach unten mit Border=Abstand den Reihen und wieder dem Abstand initialisiert
       
        mScreen = new char [BORDER+ROWS+BORDER][X_LENGTH];
        // Erfasst den Screen
        clearScreen();
        //
        writeFieldBorders();
        mScanner = new Scanner(System.in);
        
    } 
    
   private void clearScreen() {
	  //mScreen length = 16 das Border = 3 + Rows = 10 + Border = 3
	   for (int i = 0; i < mScreen.length; i++) {
		   //mScreen[0].length = 79 wegen Länge des Screens
		  for (int j = 0; j < mScreen[0].length; j++) {
			  // Für die Länge von 79 soll der Char ' ' erfasst werden
			  mScreen[i][j]= ' ';
		}
		
	}
   }
    
    private void writeFieldBorders() {
        for (int col = BORDER - 1; col < COLS + BORDER + 1; col++) {
           // Hier schreibt das Programm die Bindestriche
        	mScreen[BORDER - 1][col] = mScreen[ROWS + BORDER][col] = '-';
        }
        for (int row = BORDER - 1; row < ROWS + BORDER + 1; row++) {
        	//Hier schreibt das Programm die Seitenlinien
            mScreen[row][BORDER - 1] = mScreen[row][COLS + BORDER] = '|';
        }
        mScreen[BORDER - 1][BORDER - 1] = mScreen[BORDER - 1][COLS + BORDER] 
            = mScreen[ROWS + BORDER][BORDER - 1] 
            		//Hier schreibt das Programm die 1
            = mScreen[ROWS + BORDER][COLS + BORDER] = '+';
// die Zahlen für die Spalten werden definiert
        for (int col = 0; col < COLS; col++) {
            if (((col + 1) % 10) == 0) {
                mScreen[0][BORDER + col] = (char) ('0' + ((col + 1) / 10));
                mScreen[BORDER + ROWS + BORDER - 1][BORDER + col] 
                        = (char) ('0' + ((col + 1) / 10));
            }
        }
        for (int col = 0; col < COLS; col++) {
            mScreen[1][BORDER + col] = (char) ('0' + ((col + 1) % 10));
            mScreen[BORDER + ROWS + BORDER - 2][BORDER + col] 
                = (char) ('0' + ((col + 1) % 10));
        }
        // Die Zahlen für die Reihen werden definiert
        for (int row = 0; row < ROWS; row++) {
            if (((row + 1) % 10) == 0) {
                mScreen[BORDER + row][0] = (char) ('0' + ((row + 1) / 10));
                mScreen[BORDER + row][BORDER + COLS + BORDER - 2] 
                    = (char) ('0' + ((row + 1) / 10));
            }
        }
        for (int row = 0; row < ROWS; row++) {
            mScreen[BORDER + row][1] = (char) ('0' + ((row + 1) % 10));
            mScreen[BORDER + row][BORDER + COLS + BORDER - 1] 
                = (char) ('0' + ((row + 1) % 10));
        }
    }
    /**
     * Sets the defined Position with a new Value.
     * @param pX The X-Position (Column).
     * @param pY The Y-Position (Row).
     * @param pNewValue The new Value to be set at Position(x/y).
     */
    public void set(int pX, int pY, char pNewValue) {
    	//Definieren der Position	
    	mScreen[BORDER-1+pY][BORDER-1+pX]=pNewValue;
    }
    /**
     * Returns the Value of the defined Position.
     * @param pX The X-Position (Column).
     * @param pY The Y-Position (Row).
     * @return The Value at Position(x/y).
     */
    public char get(int pX, int pY) {
    	return mScreen[BORDER-1+pY][BORDER-1+pX];
    }  
    /**
     * Writes the String-Array pMenu to the Menu-Area.
     * @param pMenu
     */
    public void setMenu(String[] pMenu) {
        int xOffset = BORDER+COLS+BORDER+MENU_X_OFFSET;
        int menuLineLength = mScreen[0].length - xOffset;
        char[] menuEmptyLine = new char[menuLineLength];
        for (int i = 0; i < menuLineLength; i++) {
            menuEmptyLine[i] = ' ';
        }
        for (int row = 0; row < BORDER+ROWS+BORDER; row++) {
            System.arraycopy(menuEmptyLine, 0, mScreen[row], 
                             xOffset, menuEmptyLine.length);          
        }   
        int yOffset = BORDER+ROWS+BORDER - pMenu.length - 1;
        char[] menuTitle = "Menu".toCharArray();
        System.arraycopy(menuTitle, 0, mScreen[yOffset-2], 
                         xOffset, menuTitle.length);    
        char[] underline = "----".toCharArray();
        System.arraycopy(underline, 0, mScreen[yOffset-1], 
                         xOffset, underline.length);    
        for (int i = 0; i < pMenu.length; i++) {
            char[] menuArr = pMenu[i].toCharArray();
            System.arraycopy(menuArr, 0, mScreen[yOffset+i], 
                             xOffset, menuArr.length);     
        }
    }  
    /**
     * Reads an User-Input with a Prompt in the User-Input-Area (below Menu-Area).
     * 
     * @param pPrompt The Prompt-String to be used.
     * @return The Input-String given by the User.
     */
    public String userInput(String pPrompt) {
    	for (int i = 0; i < BORDER+COLS+BORDER+MENU_X_OFFSET; i++) {
    		System.out.print(' ');
		}
    	System.out.print(pPrompt);
    	String input = mScanner.nextLine();
    	return input;
    }
    /**
     * Writes the Content of the 'Screen' to the Console.
     */
    public void print() {
        System.out.println("\n\n\n\n");
        for (int y = 0; y < mScreen.length; y++) {
            System.out.println(mScreen[y]);
        }
        System.out.println("\n\n");
    }
 
    
    public static void main(String[] args) {
    	
        Screen screen = new Screen(30, 10);
        screen.set(10, 2, 'X');
        screen.set(20, 8, 'Y');
        final String[] MENU = { 
                "1. Neues Schiff", 
                "2. Neue Position",
                "3. Ende" 
        };
        screen.setMenu(MENU);
     
        screen.print();
        
        String input = screen.userInput("Ihre Wahl: ");
        System.out.println("User-Input: >" + input + "<\n");
        
        System.out.println("screen.get(10, 2): '" + screen.get(10, 2)+"'");
        System.out.println("screen.get( 1, 1): '" + screen.get( 1, 1)+"'");
    }
}

/* Session-Log:

            1         2         3                                              
   123456789012345678901234567890                                              
  +------------------------------+                                             
 1|                              | 1                                           
 2|         X                    | 2                                           
 3|                              | 3                                           
 4|                              | 4                                           
 5|                              | 5                                           
 6|                              | 6                                           
 7|                              | 7                                           
 8|                   Y          | 8          Menu                            
 9|                              | 9          ----                            
10|                              |10          1. Neues Schiff                  
  +------------------------------+            2. Neue Position                 
   123456789012345678901234567890             3. Ende                          
            1         2         3                                              



                                              Ihre Wahl: 1
User-Input: >1<

screen.get(10, 2): 'X'
screen.get( 1, 1): ' '

*/

 

