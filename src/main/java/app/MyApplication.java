package app;

import GUI.Controller;
import GUI.Model;
import GUI.Viewer;
import dataModels.Operations;
import dataModels.Polynomial;
import dataModels.IntMonomial;
import dataModels.DoubleMonomial;
import dataModels.Monomial;
import java.util.ArrayList;

public class MyApplication {
    public static void main(String[] args) {
        Viewer myView = new Viewer();
        Model myModel = new Model();
        Controller myController = new Controller(myView, myModel);
        myView.setVisible(true);

    }
}
