
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Chart_Screen extends JFrame {

	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Chart_Screen() {
		initComponents();
		JFreeChart chart = ChartFactory.createBarChart("Most Common Causes of Loss", "Cause of Loss",
				"Number of Beneficiaries", createDataset(), PlotOrientation.VERTICAL, false, false, false);

		ChartPanel panel = new ChartPanel(chart);
		setContentPane(panel);
	}

	private CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		int agr = 0, elec = 0, ind = 0, veh = 0, bd = 0, vr = 0, wl = 0, oth = 0;

		for (Beneficiary_Data b : Home_Menu.benList) {

			if (b.getHand().getCauseOfLoss().contains("Agricultural")) {
				agr++;
			} else if (b.getHand().getCauseOfLoss().contains("Electrocution")) {
				elec++;
			} else if (b.getHand().getCauseOfLoss().contains("Industrial")) {
				ind++;
			} else if (b.getHand().getCauseOfLoss().contains("Vehicular")) {
				veh++;
			} else if (b.getHand().getCauseOfLoss().contains("Birth")) {
				bd++;
			} else if (b.getHand().getCauseOfLoss().contains("Violence")) {
				vr++;
			} else if (b.getHand().getCauseOfLoss().contains("War")) {
				wl++;
			} else {
				oth++;
			}
		}

		dataset.addValue(agr, "", "Agricultural");
		dataset.addValue(elec, "", "Electrocution");
		dataset.addValue(ind, "", "Industrial");
		dataset.addValue(veh, "", "Vehicular");
		dataset.addValue(bd, "", "Birth Defect");
		dataset.addValue(vr, "", "Violence, Robbery, etc.");
		dataset.addValue(wl, "", "War, Landmine, etc.");
		dataset.addValue(oth, "", "Others");

		return dataset;
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setAlwaysOnTop(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Home_Menu.trendAnalysis();
			}
		});
		this.repaint(5);
	}

}
