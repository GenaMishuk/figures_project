package by.stormnet.figuresfx.controller;

import by.stormnet.figuresfx.Figures.*;
import by.stormnet.figuresfx.drawutils.Drawer;
import by.stormnet.figuresfx.simpleException.SimpleMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;


public class MainScreenViewController implements Initializable {
    private static final Logger logger = Logger.getLogger(MainScreenViewController.class.getName());
    private Random random;
    private ArrayList<Figure> figures;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        figures = new ArrayList<>(1);
        random = new Random(System.currentTimeMillis());

    }

    private void addFigure(Figure figure) {
        figures.add(figure);
        }


    private Figure createFigure(double x, double y) throws SimpleMain {
        Figure figure = null;

        switch (random.nextInt(4)) {
            case Figure.FIGURES_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(10), Color.GREEN, random.nextInt(50));
                break;
            case Figure.FIGURES_TYPE_RECTANGLE:
                figure = new Rectangle(x,y,random.nextInt(10),Color.RED,random.nextInt(100),random.nextInt(100));
                break;
            case Figure.FIGURES_TYPE_TRIANGLE:
              figure = new Triangle(x,y,random.nextInt(10),Color.PINK,random.nextInt(100));
                break;
            case Figure.FIGURES_TYPE_SQUARE:
                figure = new Square(x, y, random.nextInt(10), Color.BLACK, random.nextInt(100), random.nextInt(100));
                break;
            default:
                throw new SimpleMain("unknown figures");
        }
        logger.info(figure);
        return figure;
    }
    private void repaints(){
        canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());

            }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
    try{
        addFigure(createFigure(mouseEvent.getX(),mouseEvent.getY()));
        }catch(SimpleMain e){
        logger.error(e.getMessage());
        }
    repaints();
    }
}
