package _14InfernoInfinityRefactoring;

import _14InfernoInfinityRefactoring.annotations.CustomAnnotation;
import _14InfernoInfinityRefactoring.engine.Engine;
import _14InfernoInfinityRefactoring.models.contracts.Weapon;
import _14InfernoInfinityRefactoring.enums.Gem;
import _14InfernoInfinityRefactoring.factories.WeaponFactory;
import _14InfernoInfinityRefactoring.models.WeaponImpl;
import _14InfernoInfinityRefactoring.repositories.Repository;
import _14InfernoInfinityRefactoring.repositories.WeaponRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Runnable engine = new Engine();

        engine.run();
    }
}

