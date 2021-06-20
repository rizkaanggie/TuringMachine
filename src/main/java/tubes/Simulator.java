
package tubes;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Simulator extends javax.swing.JFrame {
	
	static public javax.swing.JFrame simulator;

    public Simulator() {
    	setTitle("Turing Machine Simulator");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Simulator.class.getResource("/img/logo.png")));
    	setBounds(100, 100, 640, 480);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        btnPerkalian = new com.k33ptoo.components.KButton();
        btnPerkalian.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new FramePerkalian().setVisible(true);
        		simulator.setVisible(false);
        	}
        });
        btnPengurangan = new com.k33ptoo.components.KButton();
        btnPengurangan.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new FramePengurangan().setVisible(true);
        		simulator.setVisible(false);
        	}
        });
        btnPenjumlahan = new com.k33ptoo.components.KButton();
        btnPenjumlahan.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new FramePenjumlahan().setVisible(true);
        		simulator.setVisible(false);
        	}
        });
        btnPembagian = new com.k33ptoo.components.KButton();
        btnPembagian.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new FramePembagian().setVisible(true);
        		simulator.setVisible(false);
        	}
        });
        btnFaktorial = new com.k33ptoo.components.KButton();
        btnFaktorial.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new FrameFaktorial().setVisible(true);
        		simulator.setVisible(false);
        	}
        });
        btnModulo = new com.k33ptoo.components.KButton();
        btnModulo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new FrameModulo().setVisible(true);
        		simulator.setVisible(false);
        	}
        });
        btnPangkat = new com.k33ptoo.components.KButton();
        btnPangkat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new FramePerpangkatan().setVisible(true);
        		simulator.setVisible(false);
        	}
        });
        btnLogaritma = new com.k33ptoo.components.KButton();
        btnLogaritma.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new FrameLogaritma().setVisible(true);
        		simulator.setVisible(false);
        	}
        });
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(53, 92, 125));
        kGradientPanel1.setkStartColor(new java.awt.Color(246, 114, 128));

        btnPerkalian.setBorder(null);
        btnPerkalian.setText("Perkalian");
        btnPerkalian.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnPerkalian.setkBackGroundColor(new java.awt.Color(248, 177, 149));
        btnPerkalian.setkBorderRadius(30);
        btnPerkalian.setkEndColor(new java.awt.Color(248, 177, 149));
        btnPerkalian.setkHoverEndColor(new java.awt.Color(246, 114, 128));
        btnPerkalian.setkHoverForeGround(new java.awt.Color(248, 177, 149));
        btnPerkalian.setkHoverStartColor(new java.awt.Color(192, 108, 132));
        btnPerkalian.setkPressedColor(new java.awt.Color(246, 114, 128));
        btnPerkalian.setkStartColor(new java.awt.Color(248, 177, 149));

        btnPengurangan.setBorder(null);
        btnPengurangan.setText("Pengurangan");
        btnPengurangan.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnPengurangan.setkBackGroundColor(new java.awt.Color(248, 177, 149));
        btnPengurangan.setkBorderRadius(30);
        btnPengurangan.setkEndColor(new java.awt.Color(248, 177, 149));
        btnPengurangan.setkHoverEndColor(new java.awt.Color(246, 114, 128));
        btnPengurangan.setkHoverForeGround(new java.awt.Color(248, 177, 149));
        btnPengurangan.setkHoverStartColor(new java.awt.Color(192, 108, 132));
        btnPengurangan.setkPressedColor(new java.awt.Color(246, 114, 128));
        btnPengurangan.setkStartColor(new java.awt.Color(248, 177, 149));

        btnPenjumlahan.setBorder(null);
        btnPenjumlahan.setText("Penjumlahan");
        btnPenjumlahan.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnPenjumlahan.setkBackGroundColor(new java.awt.Color(248, 177, 149));
        btnPenjumlahan.setkBorderRadius(30);
        btnPenjumlahan.setkEndColor(new java.awt.Color(248, 177, 149));
        btnPenjumlahan.setkHoverEndColor(new java.awt.Color(246, 114, 128));
        btnPenjumlahan.setkHoverForeGround(new java.awt.Color(248, 177, 149));
        btnPenjumlahan.setkHoverStartColor(new java.awt.Color(192, 108, 132));
        btnPenjumlahan.setkPressedColor(new java.awt.Color(246, 114, 128));
        btnPenjumlahan.setkStartColor(new java.awt.Color(248, 177, 149));

        btnPembagian.setBorder(null);
        btnPembagian.setText("Pembagian");
        btnPembagian.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnPembagian.setkBackGroundColor(new java.awt.Color(248, 177, 149));
        btnPembagian.setkBorderRadius(30);
        btnPembagian.setkEndColor(new java.awt.Color(248, 177, 149));
        btnPembagian.setkHoverEndColor(new java.awt.Color(246, 114, 128));
        btnPembagian.setkHoverForeGround(new java.awt.Color(248, 177, 149));
        btnPembagian.setkHoverStartColor(new java.awt.Color(192, 108, 132));
        btnPembagian.setkPressedColor(new java.awt.Color(246, 114, 128));
        btnPembagian.setkStartColor(new java.awt.Color(248, 177, 149));

        btnFaktorial.setBorder(null);
        btnFaktorial.setText("Faktorial");
        btnFaktorial.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnFaktorial.setkBackGroundColor(new java.awt.Color(248, 177, 149));
        btnFaktorial.setkBorderRadius(30);
        btnFaktorial.setkEndColor(new java.awt.Color(248, 177, 149));
        btnFaktorial.setkHoverEndColor(new java.awt.Color(246, 114, 128));
        btnFaktorial.setkHoverForeGround(new java.awt.Color(248, 177, 149));
        btnFaktorial.setkHoverStartColor(new java.awt.Color(192, 108, 132));
        btnFaktorial.setkPressedColor(new java.awt.Color(246, 114, 128));
        btnFaktorial.setkStartColor(new java.awt.Color(248, 177, 149));

        btnModulo.setBorder(null);
        btnModulo.setText("Modulo");
        btnModulo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnModulo.setkBackGroundColor(new java.awt.Color(248, 177, 149));
        btnModulo.setkBorderRadius(30);
        btnModulo.setkEndColor(new java.awt.Color(248, 177, 149));
        btnModulo.setkHoverEndColor(new java.awt.Color(246, 114, 128));
        btnModulo.setkHoverForeGround(new java.awt.Color(248, 177, 149));
        btnModulo.setkHoverStartColor(new java.awt.Color(192, 108, 132));
        btnModulo.setkPressedColor(new java.awt.Color(246, 114, 128));
        btnModulo.setkStartColor(new java.awt.Color(248, 177, 149));

        btnPangkat.setBorder(null);
        btnPangkat.setText("Pangkat");
        btnPangkat.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnPangkat.setkBackGroundColor(new java.awt.Color(248, 177, 149));
        btnPangkat.setkBorderRadius(30);
        btnPangkat.setkEndColor(new java.awt.Color(248, 177, 149));
        btnPangkat.setkHoverEndColor(new java.awt.Color(246, 114, 128));
        btnPangkat.setkHoverForeGround(new java.awt.Color(248, 177, 149));
        btnPangkat.setkHoverStartColor(new java.awt.Color(192, 108, 132));
        btnPangkat.setkPressedColor(new java.awt.Color(246, 114, 128));
        btnPangkat.setkStartColor(new java.awt.Color(248, 177, 149));

        btnLogaritma.setBorder(null);
        btnLogaritma.setText("Log Biner");
        btnLogaritma.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnLogaritma.setkBackGroundColor(new java.awt.Color(248, 177, 149));
        btnLogaritma.setkBorderRadius(30);
        btnLogaritma.setkEndColor(new java.awt.Color(248, 177, 149));
        btnLogaritma.setkHoverEndColor(new java.awt.Color(246, 114, 128));
        btnLogaritma.setkHoverForeGround(new java.awt.Color(248, 177, 149));
        btnLogaritma.setkHoverStartColor(new java.awt.Color(192, 108, 132));
        btnLogaritma.setkPressedColor(new java.awt.Color(246, 114, 128));
        btnLogaritma.setkStartColor(new java.awt.Color(248, 177, 149));

        jLabel1.setFont(new Font("Verdana", Font.ITALIC, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("- Simulator -");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(248, 177, 149));
        jLabel2.setText("MACHINE");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("TURING");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPengurangan, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPembagian, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPenjumlahan, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerkalian, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogaritma, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFaktorial, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1)))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(btnFaktorial, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogaritma, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(btnPenjumlahan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPengurangan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPerkalian, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPembagian, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public static void display() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	simulator = new Simulator();
            	simulator.setBounds(100, 100, 640, 480);
            	simulator.setLocationRelativeTo(null);
            	simulator.setVisible(true);
            }
        });
    }
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.k33ptoo.components.KButton btnPerkalian;
    private com.k33ptoo.components.KButton btnPengurangan;
    private com.k33ptoo.components.KButton btnPenjumlahan;
    private com.k33ptoo.components.KButton btnPembagian;
    private com.k33ptoo.components.KButton btnFaktorial;
    private com.k33ptoo.components.KButton btnModulo;
    private com.k33ptoo.components.KButton btnPangkat;
    private com.k33ptoo.components.KButton btnLogaritma;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;

}
