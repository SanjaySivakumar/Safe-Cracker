// Sai Charan Todunpoori
// Mr. Jason Tully
// 2nd Period

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SCMain extends Application {

    private static int code = (int)(Math.random()*2014);
    private int height = 35;
    private int width = 25;
    private boolean reset = false;
    private boolean higher = false;
    private boolean lower = false;

    private int n = 0;
    private String text = "";

    private int greenRow = 3;
    private int greenColumn = 0;
    private int blueRow = 3;
    private int blueColumn = 1;
    private int redRow = 3;
    private int redColumn = 2;

    private char[][] grid = new char[][] {
            {'3', '4', '5', '6', '7', '8'},
            {'2', '2', '3', '4', '5', '9'},
            {'1', '1', '1', '2', '6', 'A'},
            {'0', '0', '0', '3', '7', 'B'},
            {'J', 'B', 'A', '9', '8', 'C'},
            {'I', 'H', 'G', 'F', 'E', 'D'}
    };

    private Rectangle greenUp = new Rectangle(width, height, Color.GREEN);
    private Rectangle greenDown = new Rectangle(width, height, Color.GREEN);
    private Rectangle blueUp = new Rectangle(width, height, Color.BLUE);
    private Rectangle blueDown = new Rectangle(width, height, Color.BLUE);
    private Rectangle redUp = new Rectangle(width, height, Color.RED);
    private Rectangle redDown = new Rectangle(width, height, Color.RED);
    private Rectangle test = new Rectangle(97.5, 310, 160, 70);

    public static void main(String[] args) {
        while(code%10 == 4 || code%10 == 5 || code%10 == 6 || code%10 == 7 || code%10 == 8 || code%10 == 9)
            code = (int)(Math.random()*2014);
        System.out.println(code);//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Safe Cracker");
        Group group = new Group();

        primaryStage.show();

        Canvas canvas = new Canvas(500, 500);

        greenUp.setX(10);
        greenUp.setY(310);
        greenDown.setX(10);
        greenDown.setY(345);
        blueUp.setX(35);
        blueUp.setY(310);
        blueDown.setX(35);
        blueDown.setY(345);
        redUp.setX(60);
        redUp.setY(310);
        redDown.setX(60);
        redDown.setY(345);

        canvas.setOnMousePressed(mouseEvent -> {
            // gets the clicked coordinates
            double x = mouseEvent.getX();
            double y = mouseEvent.getY();

            // checks all of the Rectangles (up-down buttons and test/reset)
            // to see if the point falls within one of them (meaning it is pressed)
            if(reset) {}
            else{
                if (greenUp.contains(x, y)) {
                    if (greenColumn == 0 && greenRow == 0) {
                        greenColumn++;
                    } else if (greenColumn == 0 && greenRow == grid.length - 1) {
                        greenRow--;
                    } else if (greenColumn == grid[0].length - 1 && greenRow == 0) {
                        greenRow++;
                    } else if (greenColumn == grid[0].length - 1 && greenRow == grid.length - 1) {
                        greenColumn--;
                    } else if (greenRow == 0) {
                        greenColumn++;
                    } else if (greenRow == grid.length - 1) {
                        greenColumn--;
                    } else if (greenColumn == 0) {
                        greenRow--;
                    } else if (greenColumn == grid[0].length - 1) {
                        greenRow++;
                    }
                } // navigation

                else if (greenDown.contains(x, y)) {
                    if (greenColumn == 0 && greenRow == 0) {
                        greenRow++;
                    } else if (greenColumn == 0 && greenRow == grid.length - 1) {
                        greenColumn++;
                    } else if (greenColumn == grid[0].length - 1 && greenRow == 0) {
                        greenColumn--;
                    } else if (greenColumn == grid[0].length - 1 && greenRow == grid.length - 1) {
                        greenRow--;
                    } else if (greenRow == 0) {
                        greenColumn--;
                    } else if (greenRow == grid.length - 1) {
                        greenColumn++;
                    } else if (greenColumn == 0) {
                        greenRow++;
                    } else if (greenColumn == grid[0].length - 1) {
                        greenRow--;
                    }
                } // navigation

                else if (blueUp.contains(x, y)) {
                    if (blueColumn == 1 && blueRow == 1) {
                        blueColumn++;
                    } else if (blueColumn == 1 && blueRow == grid.length - 2) {
                        blueRow--;
                    } else if (blueColumn == grid[1].length - 2 && blueRow == 1) {
                        blueRow++;
                    } else if (blueColumn == grid[1].length - 2 && blueRow == grid.length - 2) {
                        blueColumn--;
                    } else if (blueRow == 1) {
                        blueColumn++;
                    } else if (blueRow == grid.length - 2) {
                        blueColumn--;
                    } else if (blueColumn == 1) {
                        blueRow--;
                    } else if (blueColumn == grid[1].length - 2) {
                        blueRow++;
                    }
                } // navigation

                else if (blueDown.contains(x, y)) {
                    if (blueColumn == 1 && blueRow == 1) {
                        blueRow++;
                    } else if (blueColumn == 1 && blueRow == grid.length - 2) {
                        blueColumn++;
                    } else if (blueColumn == grid[1].length - 2 && blueRow == 1) {
                        blueColumn--;
                    } else if (blueColumn == grid[1].length - 2 && blueRow == grid.length - 2) {
                        blueRow--;
                    } else if (blueRow == 1) {
                        blueColumn--;
                    } else if (blueRow == grid.length - 2) {
                        blueColumn++;
                    } else if (blueColumn == 1) {
                        blueRow++;
                    } else if (blueColumn == grid[1].length - 2) {
                        blueRow--;
                    }
                } // navigation

                else if (redUp.contains(x, y)) {
                    if (redRow == 3 && redColumn == 2) {
                        redRow--;
                    } else if (redRow == 2 && redColumn == 2) {
                        redColumn++;
                    } else if (redRow == 2 && redColumn == 3) {
                        redRow++;
                    } else if (redRow == 3 && redColumn == 3) {
                        redColumn--;
                    }
                } // navigation

                else if (redDown.contains(x, y)) {
                    if (redRow == 3 && redColumn == 2) {
                        redColumn++;
                    } else if (redRow == 2 && redColumn == 2) {
                        redRow++;
                    } else if (redRow == 2 && redColumn == 3) {
                        redColumn--;
                    } else if (redRow == 3 && redColumn == 3) {
                        redRow--;
                    }
                } // navigation
            }
            if (test.contains(x, y)) {
                if (reset) {
                    n = 0;
                    greenRow = 3;
                    greenColumn = 0;
                    blueRow = 3;
                    blueColumn = 1;
                    redRow = 3;
                    redColumn = 2;
                    reset = false;
                    higher = false;
                    lower = false;
                    code = (int) (Math.random() * 2014);
                    while (code % 10 == 4 || code % 10 == 5 || code % 10 == 6 || code % 10 == 7 || code % 10 == 8 || code % 10 == 9)
                        code = (int) (Math.random() * 2014);
                    System.out.println(code);//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                } // resets all necessary variables
                else {
                    n++; // counter to monitor # of attempts

                    // to get the chars into string form
                    String s1 = grid[greenRow][greenColumn] + "";
                    String s2 = grid[blueRow][blueColumn] + "";
                    String s3 = grid[redRow][redColumn] + "";

                    // to turn letters chars into number values
                    if (s1.equals("A")) {
                        s1 = "10";
                    }
                    if (s1.equals("B")) {
                        s1 = "11";
                    }
                    if (s1.equals("C")) {
                        s1 = "12";
                    }
                    if (s1.equals("D")) {
                        s1 = "13";
                    }
                    if (s1.equals("E")) {
                        s1 = "14";
                    }
                    if (s1.equals("F")) {
                        s1 = "15";
                    }
                    if (s1.equals("G")) {
                        s1 = "16";
                    }
                    if (s1.equals("H")) {
                        s1 = "17";
                    }
                    if (s1.equals("I")) {
                        s1 = "18";
                    }
                    if (s1.equals("J")) {
                        s1 = "19";
                    }

                    if (s2.equals("A")) {
                        s2 = "10";
                    }
                    if (s2.equals("B")) {
                        s2 = "11";
                    }

                    // to make a number value
                    int combo = Integer.parseInt(s1) * 100 + Integer.parseInt(s2) * 10 + Integer.parseInt(s3);

                    // to check if ur right, more or less
                    if (combo == code) {
                        reset = true;
                    } else if (combo > code) {
                        higher = true;
                    } else {
                        lower = true;
                    }
                }
            }
            drawStuff(canvas.getGraphicsContext2D());
        });

        group.getChildren().add(canvas);

        Scene scene = new Scene(group);
        primaryStage.setScene(scene);

        canvas.requestFocus();
        drawStuff(canvas.getGraphicsContext2D());
        primaryStage.show();
    }

    private void drawStuff(GraphicsContext gc) {
        for(int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                // monitor where the selected number is
                if((i==greenRow && j==greenColumn) || (i==blueRow && j==blueColumn) || (i==redRow && j==redColumn)) {
                    gc.setFill(Color.GRAY);
                }
                else if(i == 0 || j == 0 || i == grid.length-1 || j == grid[i].length-1) {
                    gc.setFill(Color.GREEN);
                }
                else if(i == 1 || j == 1 || i == grid.length-2 || j == grid[i].length-2) {
                    gc.setFill(Color.BLUE);
                }
                else {
                    gc.setFill(Color.RED);
                }
                gc.fillRect(j*80+10, i*50, 80, 50);
                gc.strokeRect(j*80+10, i*50, 80, 50);
                gc.setFill(Color.BLACK);
                gc.setFont(new Font("Impact", 30));
                gc.fillText(grid[i][j]+"", j*80+42.5, i*50+37.5);
            }

        // GREEN

        gc.setFill(Color.GREEN);
        gc.fillRect(greenUp.getX(),greenUp.getY(),greenUp.getWidth(),greenUp.getHeight());
        gc.strokeRect(greenUp.getX(),greenUp.getY(),greenUp.getWidth(),greenUp.getHeight());
        gc.fillRect(greenDown.getX(),greenDown.getY(),greenDown.getWidth(),greenDown.getHeight());
        gc.strokeRect(greenDown.getX(),greenDown.getY(),greenDown.getWidth(),greenDown.getHeight());

        // BLUE

        gc.setFill(Color.BLUE);
        gc.fillRect(blueUp.getX(),blueUp.getY(),blueUp.getWidth(),blueUp.getHeight());
        gc.strokeRect(blueUp.getX(),blueUp.getY(),blueUp.getWidth(),blueUp.getHeight());
        gc.fillRect(blueDown.getX(),blueDown.getY(),blueDown.getWidth(),blueDown.getHeight());
        gc.strokeRect(blueDown.getX(),blueDown.getY(),blueDown.getWidth(),blueDown.getHeight());

        // RED

        gc.setFill(Color.RED);
        gc.fillRect(redUp.getX(),redUp.getY(),redUp.getWidth(),redUp.getHeight());
        gc.strokeRect(redUp.getX(),redUp.getY(),redUp.getWidth(),redUp.getHeight());
        gc.fillRect(redDown.getX(),redDown.getY(),redDown.getWidth(),redDown.getHeight());
        gc.strokeRect(redDown.getX(),redDown.getY(),redDown.getWidth(),redDown.getHeight());

        gc.setFill(Color.BLACK);

        // UP
        gc.setFont(new Font("Arial", 20));
        gc.fillText("^", 17.5, 332.5);
        gc.fillText("^", 42.5, 332.5);
        gc.fillText("^", 67.5, 332.5);
        // DOWN
        gc.setFont(new Font("Arial", 17));
        gc.fillText("v", 17.5, 367.5);
        gc.fillText("v", 42.5, 367.5);
        gc.fillText("v", 67.5, 367.5);

        gc.setFill(Color.GRAY);
        gc.fillRect(test.getX(), test.getY(), test.getWidth(), test.getHeight());
        gc.strokeRect(test.getX(), test.getY(), test.getWidth(), test.getHeight());
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Arial", 50));
        if(reset) {
            gc.fillText("Reset", test.getWidth()/2+test.getX()-65, test.getHeight()/2+test.getY()+15);
        } else {
            gc.fillText("Test", test.getWidth() / 2 + test.getX() - 52.5, test.getHeight() / 2 + test.getY() + 15);
        }
        gc.setFont(new Font("Arial", 25));
        gc.fillText("Result: ", 330, 330);
        gc.setFill(Color.WHITE);
        gc.fillRect(270, 340, 220, 40);
        gc.setFill(Color.BLACK);
        gc.strokeRect(270, 340, 220, 40);
        if(higher) {
            text = "Wrong - too high";
            higher = false;
        }
        else if(lower) {
            text = "Wrong - too low";
            lower = false;
        }
        else if(reset) {
            if(n==1) {
                text = n + " attempt!";
            }
            else {
                text = n + " attempts!";
            }
        } else {
            text = "";
        }
        gc.fillText(text, 285, 365);
    }
}
