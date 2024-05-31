package br.com.alura.conversorDeMoedas.classes;

import java.util.HashMap;

public record Currency(HashMap<String, Double> conversion_rates) {
}
