import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class GeneradorRecetasUnico {

    // Cambié el color principal a naranja fuerte
    private static final Color PRIMARY_ORANGE = new Color(255, 100, 0);
    private static final Color TEXT_DARK_GRAY = new Color(51, 51, 51);
    private static final Color BORDER_GRAY = new Color(203, 213, 225);
    private static final Dimension ING_BTN_SIZE = new Dimension(120, 40);

    private final List<JToggleButton> ingredientesBtns = new ArrayList<>();
    private final Map<String, List<String>> categoriaMap = new LinkedHashMap<>();
    private final CardLayout cardLayout = new CardLayout();
    private JPanel pnlIngredientesCards;
    private final List<JButton> categoriaBtns = new ArrayList<>();
    private final ButtonGroup prefsGroup = new ButtonGroup();
    private JButton btnGenerar;
    private JLabel lblPrefSeleccionada;

    private final List<Receta> recetas = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GeneradorRecetasUnico().initUI());
    }

    private void initUI() {
        initCategorias();
        initRecetas();

        JFrame frame = new JFrame("¡Empecemos a cocinar!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Aumenté el tamaño del frame
        frame.setSize(1200, 900);
        frame.setLocationRelativeTo(null);

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        // Aumenté el padding del contenedor principal
        ((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.add(crearHeaderPanel());
        frame.add(Box.createVerticalStrut(15));
        frame.add(crearCentroPanel());
        frame.add(Box.createVerticalStrut(15));
        frame.add(crearFooterPanel(frame));

        frame.setVisible(true);
    }

    private void initCategorias() {
        List<String> proteinas = Arrays.asList("Carne de res", "Pollo", "Pavo", "Pescado", "Mariscos", "Huevo",
                "Leche", "Queso", "Yogur", "Jamón", "Frijoles", "Lentejas", "Garbanzos", "Soya", "Chícharos",
                "Amaranto", "Quinoa", "Nueces", "Semillas", "Avena", "Pan integral");
        List<String> granos = Arrays.asList("Arroz", "Maiz", "Pasta", "Pan", "Avena", "Amaranto", "Galletas integrales",
                "Tortillas de maíz", "Frijoles", "Lentejas", "Garbanzos", "Chícharos secos", "Soya");
        List<String> vegetales = Arrays.asList("Tomate", "Tomatillo", "Cebolla", "Aguacate", "Ajo", "Lechuga", "Espinaca",
                "Acelga", "Zanahoria", "Apio", "Calabacín", "Chayote", "Nopal", "Elote", "Pepino", "Betabel", "Chile",
                "Brócoli", "Papa");
        List<String> lacteos = Arrays.asList("Leche", "Queso", "Yogur", "Crema", "Mantequilla", "Helado",
                "Queso crema", "Leche condensada", "Leche evaporada");
        List<String> condimentos = Arrays.asList("Sal", "Pimienta", "Aceite oliva", "Orégano", "Comino", "Canela", "Clavo",
                "Laurel", "Chile en polvo", "Mostaza", "Vinagre", "Limón", "Salsa de soya", "Salsa inglesa", "Kétchup",
                "Mayonesa", "Cilantro", "Perejil", "Tomillo", "Romero");
        List<String> frutas = Arrays.asList("Manzana", "Plátano", "Limón", "Aguacate");

        categoriaMap.put("Proteínas", proteinas);
        categoriaMap.put("Granos", granos);
        categoriaMap.put("Vegetales", vegetales);
        categoriaMap.put("Lácteos", lacteos);
        categoriaMap.put("Condimentos", condimentos);
        categoriaMap.put("Frutas", frutas);
    }

    private void initRecetas() {
        recetas.add(new Receta("Arroz con Pollo", "Clásico y fácil", new String[]{"Pollo", "Arroz", "Zanahoria", "Cebolla"},
                "45 min", "4", "Fácil", "Sin restricciones", new String[]{
                "Lavar y picar los ingredientes.",
                "Sofreír el pollo con cebolla y zanahoria.",
                "Agregar arroz y agua.",
                "Cocinar a fuego medio hasta que se absorba el agua."
        }));

        recetas.add(new Receta("Carne Asada", "Sencilla y deliciosa", new String[]{"Carne de res", "Sal", "Pimienta", "Limón"},
                "30 min", "3", "Fácil", "Sin restricciones", new String[]{
                "Marinar la carne con sal, pimienta y limón.",
                "Calentar la parrilla y asar la carne por ambos lados.",
                "Servir con limón extra al gusto."
        }));

        recetas.add(new Receta("Ensalada de Pollo", "Fresca y nutritiva", new String[]{"Pollo", "Lechuga", "Tomate", "Pepino", "Mayonesa"},
                "20 min", "2", "Fácil", "Sin restricciones", new String[]{
                "Cocer y desmenuzar el pollo.",
                "Picar lechuga, tomate y pepino.",
                "Mezclar todo con mayonesa y servir frío."
        }));

        recetas.add(new Receta("Tacos Vegetarianos", "Sin carne y llenos de sabor", new String[]{"Frijoles", "Tortillas de maíz", "Lechuga", "Tomate", "Queso"},
                "25 min", "4", "Fácil", "Vegetariano", new String[]{
                "Calentar frijoles y sazonar.",
                "Calentar tortillas y rellenar con frijoles.",
                "Agregar lechuga, tomate y queso."
        }));

        recetas.add(new Receta("Bowl Vegano de Quinoa", "Ligero y saludable", new String[]{"Quinoa", "Espinaca", "Aguacate", "Tomate"},
                "30 min", "2", "Fácil", "Vegano", new String[]{
                "Cocer la quinoa.",
                "Picar espinaca, aguacate y tomate.",
                "Servir la quinoa con las verduras encima."
        }));

        recetas.add(new Receta("Ensalada Sin Gluten", "Ideal para celíacos", new String[]{"Lechuga", "Pepino", "Tomate", "Aguacate", "Limón"},
                "15 min", "2", "Fácil", "Sin gluten", new String[]{
                "Lavar y picar todos los ingredientes.",
                "Mezclar en un tazón.",
                "Aderezar con limón."
        }));

        recetas.add(new Receta("Batido Sin Lactosa", "Refrescante y fácil", new String[]{"Plátano", "Avena", "Leche de soya", "Miel"},
                "10 min", "1", "Fácil", "Sin lactosa", new String[]{
                "Colocar los ingredientes en la licuadora.",
                "Licuar hasta obtener una mezcla homogénea.",
                "Servir frío."
        }));
    }
    private JPanel crearHeaderPanel() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("¡Empecemos a cocinar!");
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setForeground(PRIMARY_ORANGE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel(
                "<html><center>Selecciona los ingredientes que tienes disponibles y tus preferencias alimenticias.<br>"
                        + "Nuestro sistema te sugerirá las mejores recetas personalizadas para ti.</center></html>"
        );
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 16));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(title);
        header.add(Box.createVerticalStrut(8));
        header.add(subtitle);

        return header;
    }

    private JPanel crearCentroPanel() {
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.X_AXIS));
        centro.add(crearPanelIngredientes());
        centro.add(Box.createHorizontalStrut(20));
        centro.add(crearPanelPreferencias());
        return centro;
    }

    private JPanel crearPanelIngredientes() {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setPreferredSize(new Dimension(750, 500));
        panel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK, 5, true), // borde más grueso y negro fuerte
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));


        // Título interno dentro del panel
        JLabel lblTitulo = new JLabel("Selecciona tus ingredientes disponibles");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(lblTitulo, BorderLayout.NORTH);

        // Panel de botones de categorías
        JPanel cats = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));
        for (String cat : categoriaMap.keySet()) {
            JButton b = new JButton(cat);
            estiloCategoriaBtn(b);
            b.addActionListener(e -> {
                cardLayout.show(pnlIngredientesCards, cat);
                resaltarCategoriaSeleccionada(b);
            });
            categoriaBtns.add(b);
            cats.add(b);
        }

        // Panel central que contiene las categorías y los ingredientes
        JPanel centro = new JPanel(new BorderLayout(8, 8));
        centro.add(cats, BorderLayout.NORTH);

        pnlIngredientesCards = new JPanel(cardLayout);
        for (Map.Entry<String, List<String>> entry : categoriaMap.entrySet()) {
            JPanel grid = new JPanel(new GridLayout(0, 4, 8, 8));
            for (String ing : entry.getValue()) {
                JToggleButton t = new JToggleButton(ing);
                estiloIngredienteBtn(t);
                t.addItemListener(evt -> estilizarIngredienteSeleccionado(t, evt.getStateChange() == ItemEvent.SELECTED));
                ingredientesBtns.add(t);
                grid.add(t);
            }
            pnlIngredientesCards.add(new JScrollPane(grid), entry.getKey());
        }
        centro.add(pnlIngredientesCards, BorderLayout.CENTER);

        panel.add(centro, BorderLayout.CENTER);

        // Mostrar primera categoría por defecto
        cardLayout.show(pnlIngredientesCards, "Proteínas");
        resaltarCategoriaSeleccionada(categoriaBtns.get(0));

        return panel;
    }


    private JPanel crearPanelPreferencias() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(8, 8));
        panel.setPreferredSize(new Dimension(380, 500));
        panel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.orange, 3, true),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        // Título interno centrado
        JLabel lblTitulo = new JLabel("Preferencias alimenticias");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblTitulo, BorderLayout.NORTH);

        // Panel para radio buttons + descripciones
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));

        String[][] prefs = {
                {"Sin restricciones", "Puedo comer cualquier tipo de alimento"},
                {"Vegetariano", "No como carne ni pescado"},
                {"Vegano", "No consumo productos de origen animal"},
                {"Sin gluten", "Evito alimentos con gluten"},
                {"Sin lactosa", "No puedo consumir lácteos"}
        };

        boolean primera = true;
        for (String[] p : prefs) {
            JRadioButton r = new JRadioButton(p[0]);
            r.setFont(new Font("SansSerif", Font.PLAIN, 14));
            prefsGroup.add(r);

            JLabel desc = new JLabel("<html><i style='font-size:12px;color:gray;'>" + p[1] + "</i></html>");
            JPanel celda = new JPanel(new BorderLayout(5, 5));
            celda.add(r, BorderLayout.NORTH);
            celda.add(desc, BorderLayout.CENTER);

            celda.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(Color.BLACK, 2, true), // borde redondeado negro
                    BorderFactory.createEmptyBorder(10, 10, 10, 10) // padding interno
            ));

            celda.setBackground(Color.WHITE);
            r.setBackground(Color.WHITE);
            desc.setBackground(Color.WHITE);

            contenedor.add(Box.createVerticalStrut(10)); // espacio entre celdas
            contenedor.add(celda);



            r.addActionListener(e -> {
                lblPrefSeleccionada.setText("Preferencia seleccionada: " + p[0]);
                btnGenerar.setEnabled(anyIngredienteSelected());
            });

            if (primera) {
                r.setSelected(true);
                lblPrefSeleccionada = new JLabel("Preferencia seleccionada: " + p[0]);
                lblPrefSeleccionada.setFont(new Font("SansSerif", Font.BOLD, 14));
                lblPrefSeleccionada.setBorder(BorderFactory.createEmptyBorder(12, 8, 8, 8));
                primera = false;
            }
        }

        panel.add(new JScrollPane(contenedor), BorderLayout.CENTER);
        panel.add(lblPrefSeleccionada, BorderLayout.SOUTH);

        return panel;
    }


    private JPanel crearFooterPanel(JFrame frame) {
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));

        btnGenerar = new JButton("Generar recetas personalizadas");
        btnGenerar.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnGenerar.setBackground(PRIMARY_ORANGE);
        btnGenerar.setForeground(Color.BLACK);
        btnGenerar.setEnabled(false);
        btnGenerar.setPreferredSize(new Dimension(280, 45));

        btnGenerar.addActionListener(e -> mostrarListaRecetas(frame));

        JButton btnVerTodas = new JButton("Ver todas las recetas");
        btnVerTodas.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnVerTodas.setBackground(Color.LIGHT_GRAY);
        btnVerTodas.setForeground(Color.BLACK);
        btnVerTodas.setPreferredSize(new Dimension(250, 45));
        btnVerTodas.addActionListener(e -> mostrarTodasLasRecetas(frame));

        footer.add(btnGenerar);
        footer.add(btnVerTodas);

        return footer;
    }
    private void mostrarListaRecetas(JFrame frame) {
        List<String> disponibles = new ArrayList<>();
        for (JToggleButton t : ingredientesBtns) {
            if (t.isSelected()) disponibles.add(t.getText());
        }

        String pref = Collections.list(prefsGroup.getElements()).stream()
                .filter(AbstractButton::isSelected)
                .findFirst().map(AbstractButton::getText).orElse("Sin restricciones");

        JDialog dialog = new JDialog(frame, "Elige una receta", true);
        dialog.setSize(350, 450);
        dialog.setLocationRelativeTo(frame);

        DefaultListModel<String> model = new DefaultListModel<>();
        List<Receta> recetasFiltradas = new ArrayList<>();

        for (Receta r : recetas) {
            if (r.aptoPara.equals(pref) || (pref.equals("Sin restricciones") && r.aptoPara.equals("Sin restricciones"))) {
                boolean tieneTodo = true;
                for (String ing : r.ingredientes) {
                    if (!disponibles.contains(ing)) {
                        tieneTodo = false;
                        break;
                    }
                }
                if (tieneTodo) {
                    recetasFiltradas.add(r);
                    model.addElement(r.nombre);
                }
            }
        }

        if (recetasFiltradas.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay recetas disponibles con los ingredientes y preferencia seleccionados.",
                    "Sin recetas", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JList<String> lista = new JList<>(model);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Receta r = recetasFiltradas.get(lista.getSelectedIndex());
                new RecetaDialog(frame, r, disponibles, pref).setVisible(true);
            }
        });

        dialog.add(new JScrollPane(lista));
        dialog.setVisible(true);
    }

    private void mostrarTodasLasRecetas(JFrame frame) {
        JDialog dialog = new JDialog(frame, "Todas las recetas", true);
        dialog.setSize(350, 450);
        dialog.setLocationRelativeTo(frame);

        DefaultListModel<String> model = new DefaultListModel<>();
        for (Receta r : recetas) {
            model.addElement(r.nombre + " (" + r.aptoPara + ")");
        }

        JList<String> lista = new JList<>(model);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Receta r = recetas.get(lista.getSelectedIndex());
                // todos los ingredientes de la receta se marcan ✅
                new RecetaDialog(frame, r, Arrays.asList(r.ingredientes), r.aptoPara).setVisible(true);
            }
        });

        dialog.add(new JScrollPane(lista));
        dialog.setVisible(true);
    }

    private Border compoundRoundedBorder(String title) {
        return new CompoundBorder(
                new TitledBorder(
                        new LineBorder(Color.BLACK, 3, true), // borde negro fuerte
                        title,
                        TitledBorder.CENTER, // <-- Centrado
                        TitledBorder.TOP,
                        new Font("SansSerif", Font.BOLD, 16),
                        Color.BLACK
                ),
                BorderFactory.createEmptyBorder(20, 20, 20, 20) // Espacio interior
        );
    }


    private void estiloCategoriaBtn(JButton b) {
        b.setFont(new Font("SansSerif", Font.PLAIN, 12));
        b.setBackground(Color.WHITE);
        b.setForeground(Color.BLACK);
        // Cambié el color del borde a naranja fuerte
        b.setBorder(new LineBorder(PRIMARY_ORANGE, 2, true));
        b.setFocusPainted(false);
        // Reducí el tamaño de los botones de categoría
        b.setPreferredSize(new Dimension(110, 35));
    }

    private void resaltarCategoriaSeleccionada(JButton sel) {
        for (JButton b : categoriaBtns) {
            if (b == sel) {
                b.setBackground(new Color(220, 220, 220)); // Gris bajito
                b.setForeground(Color.BLACK);
            } else {
                b.setBackground(Color.WHITE);
                b.setForeground(Color.BLACK);
            }
        }
    }

    private void estiloIngredienteBtn(JToggleButton t) {
        t.setFont(new Font("SansSerif", Font.PLAIN, 14));
        t.setBackground(Color.WHITE);
        t.setForeground(Color.BLACK);
        t.setBorder(new LineBorder(PRIMARY_ORANGE, 2, true));
        t.setFocusPainted(false);
        t.setPreferredSize(new Dimension(140, 45));
        t.setOpaque(true); // Asegura que el fondo se pinte
    }


    private void estilizarIngredienteSeleccionado(JToggleButton t, boolean selected) {
        if (selected) {
            t.setBackground(new Color(230, 230, 230)); // Gris bajito más visible
            t.setForeground(Color.BLACK);
            t.setBorder(new LineBorder(PRIMARY_ORANGE, 3, true));
            t.setOpaque(true);
        } else {
            estiloIngredienteBtn(t);
        }
        btnGenerar.setEnabled(anyIngredienteSelected());
    }



    private boolean anyIngredienteSelected() {
        return ingredientesBtns.stream().anyMatch(AbstractButton::isSelected);
    }
}
class Receta {
    String nombre, descripcion, tiempo, porciones, dificultad, aptoPara;
    String[] ingredientes, pasos;

    Receta(String nombre, String descripcion, String[] ingredientes,
           String tiempo, String porciones, String dificultad, String aptoPara, String[] pasos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
        this.tiempo = tiempo;
        this.porciones = porciones;
        this.dificultad = dificultad;
        this.aptoPara = aptoPara;
        this.pasos = pasos;
    }
}

class RecetaDialog extends JDialog {
    RecetaDialog(JFrame owner, Receta r, List<String> disponibles, String pref) {
        super(owner, r.nombre, true);
        setSize(550, 650);
        setLocationRelativeTo(owner);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        content.add(new JLabel("<html><h2>" + r.nombre + "</h2></html>"));
        content.add(new JLabel(r.descripcion));
        content.add(new JLabel("⏱️ " + r.tiempo + " | 👥 " + r.porciones + " | 🔹 " + r.dificultad));

        JPanel ingrPanel = new JPanel();
        ingrPanel.setLayout(new BoxLayout(ingrPanel, BoxLayout.Y_AXIS));
        ingrPanel.setBorder(BorderFactory.createTitledBorder("Ingredientes"));

        for (String ing : r.ingredientes) {
            JLabel lbl = new JLabel();
            if (disponibles.contains(ing)) {
                lbl.setText("✅ " + ing);
                lbl.setForeground(new Color(0, 128, 0));
            } else {
                lbl.setText("❌ " + ing);
                lbl.setForeground(Color.RED);
            }
            ingrPanel.add(lbl);
        }
        content.add(new JScrollPane(ingrPanel));

        content.add(new JLabel("Apto para: " + r.aptoPara));
        content.add(new JLabel("Tu preferencia: " + pref));

        content.add(new JLabel(" "));
        content.add(new JLabel("<html><h3>Pasos para preparar:</h3></html>"));
        JPanel pasosPanel = new JPanel();
        pasosPanel.setLayout(new BoxLayout(pasosPanel, BoxLayout.Y_AXIS));
        for (String paso : r.pasos) {
            pasosPanel.add(new JLabel("• " + paso));
        }
        content.add(new JScrollPane(pasosPanel));

        add(content);
    }
}