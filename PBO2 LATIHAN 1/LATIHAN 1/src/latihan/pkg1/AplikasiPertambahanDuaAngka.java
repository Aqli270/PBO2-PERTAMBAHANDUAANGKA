/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package latihan.pkg1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AplikasiPertambahanDuaAngka {
    public static void main(String[] args) {
        // Membuat frame utama
        JFrame frame = new JFrame("Aplikasi Perhitungan Dua Angka");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Panel utama
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        // Komponen GUI
        JLabel labelAngka1 = new JLabel("Angka Pertama:");
        JTextField textAngka1 = new JTextField();
        JLabel labelAngka2 = new JLabel("Angka Kedua:");
        JTextField textAngka2 = new JTextField();
        JLabel labelHasil = new JLabel("Hasil:");
        JTextField textHasil = new JTextField();
        textHasil.setEditable(false);

        JButton btnTambah = new JButton("Tambah");
        JButton btnKurang = new JButton("Kurang");
        JButton btnKali = new JButton("Kali");
        JButton btnBagi = new JButton("Bagi");
        JButton btnHapus = new JButton("Hapus");
        JButton btnKeluar = new JButton("Keluar");

        // Menambahkan komponen ke panel
        panel.add(labelAngka1);
        panel.add(textAngka1);
        panel.add(labelAngka2);
        panel.add(textAngka2);
        panel.add(labelHasil);
        panel.add(textHasil);
        panel.add(btnTambah);
        panel.add(btnKurang);
        panel.add(btnKali);
        panel.add(btnBagi);

        // Menambahkan panel ke frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(btnHapus, BorderLayout.WEST);
        frame.add(btnKeluar, BorderLayout.SOUTH);

        // Logika tombol Tambah
        btnTambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double angka1 = Double.parseDouble(textAngka1.getText());
                    double angka2 = Double.parseDouble(textAngka2.getText());
                    double hasil = angka1 + angka2;
                    textHasil.setText(String.valueOf(hasil));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Input hanya boleh angka.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Logika tombol Kurang
        btnKurang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double angka1 = Double.parseDouble(textAngka1.getText());
                    double angka2 = Double.parseDouble(textAngka2.getText());
                    double hasil = angka1 - angka2;
                    textHasil.setText(String.valueOf(hasil));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Input hanya boleh angka.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Logika tombol Kali
        btnKali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double angka1 = Double.parseDouble(textAngka1.getText());
                    double angka2 = Double.parseDouble(textAngka2.getText());
                    double hasil = angka1 * angka2;
                    textHasil.setText(String.valueOf(hasil));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Input hanya boleh angka.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Logika tombol Bagi
        btnBagi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double angka1 = Double.parseDouble(textAngka1.getText());
                    double angka2 = Double.parseDouble(textAngka2.getText());
                    if (angka2 != 0) {
                        double hasil = angka1 / angka2;
                        textHasil.setText(String.valueOf(hasil));
                    } else {
                        JOptionPane.showMessageDialog(frame, "Tidak bisa dibagi dengan nol.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Input hanya boleh angka.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Logika tombol Hapus
        btnHapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textAngka1.setText("");
                textAngka2.setText("");
                textHasil.setText("");
                textAngka1.requestFocus();
            }
        });

        // Logika tombol Keluar
        btnKeluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Membatasi input hanya angka dengan KeyAdapter
        KeyAdapter hanyaAngkaAdapter = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                }
            }
        };
        textAngka1.addKeyListener(hanyaAngkaAdapter);
        textAngka2.addKeyListener(hanyaAngkaAdapter);

        // Menambahkan FocusListener untuk membersihkan JTextField saat fokus
        FocusListener pembersihListener = new FocusListener() {
            public void focusGained(FocusEvent e) {
                JTextField textField = (JTextField) e.getSource();
                textField.setText("");
            }

            public void focusLost(FocusEvent e) {
                // Tidak perlu implementasi
            }
        };
        textAngka1.addFocusListener(pembersihListener);
        textAngka2.addFocusListener(pembersihListener);

        // Menampilkan frame
        frame.setVisible(true);
    }
}
