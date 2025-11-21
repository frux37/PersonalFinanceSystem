package model.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vanessalagomachado
 */
public class Util {

    public static String formatarDataHora(LocalDateTime data) {
        if (data == null) {
            return "Sem data definida";
        }
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return data.format(fmt);
    }

    public static boolean validaAno(int ano) {
        if (ano >= 1885 && ano <= 2026) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Data inválida! Informe data [1985 - 2026]");
            return false;
        }
    }

    public static boolean validaCPF(String CPF) {
        String regexCPF = "[0-9]{11}";

        if (!CPF.matches(regexCPF)) {
            JOptionPane.showMessageDialog(null, "CPF inválido!\n"
                    + "O formato deve ter 11 dígitos, apenas números.");
            return false;
        }

        try {
            // Calcula o primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                int num = Character.getNumericValue(CPF.charAt(i));
                soma += num * (10 - i);
            }
            int resto = 11 - (soma % 11);
            int digito1 = (resto == 10 || resto == 11) ? 0 : resto;

            // Calcula o segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                int num = Character.getNumericValue(CPF.charAt(i));
                soma += num * (11 - i);
            }
            resto = 11 - (soma % 11);
            int digito2 = (resto == 10 || resto == 11) ? 0 : resto;

            // Compara com os dígitos informados
            if (digito1 == Character.getNumericValue(CPF.charAt(9))
                    && digito2 == Character.getNumericValue(CPF.charAt(10))) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "CPF inválido!\nDígitos verificadores incorretos.");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao validar CPF: " + e.getMessage());
            return false;
        }

    }
}
