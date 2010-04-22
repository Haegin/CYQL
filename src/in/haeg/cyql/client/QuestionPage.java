package in.haeg.cyql.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class QuestionPage implements EntryPoint {

    private VerticalPanel contentPanel  = new VerticalPanel();
    private FlexTable     questionTable = new FlexTable();

    @Override public void onModuleLoad() {
        questionTable.setText(0, 0, "Question");
        questionTable.setText(0, 1, "User");
        questionTable.setText(0, 2, "Date");

        // Assemble the panels
        contentPanel.add(questionTable);
        RootPanel.get("content").add(contentPanel);
    }

}
