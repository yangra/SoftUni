package _14InfernoInfinityRefactoring.core.commands;

import _14InfernoInfinityRefactoring.annotations.CustomAnnotation;
import _14InfernoInfinityRefactoring.annotations.Inject;
import _14InfernoInfinityRefactoring.models.WeaponImpl;
import _14InfernoInfinityRefactoring.models.contracts.Weapon;
import _14InfernoInfinityRefactoring.repositories.Repository;

public abstract class Command implements Executable{

    @Inject
    private String[] params;
    @Inject
    private Repository<Weapon> weaponRepository;

    private CustomAnnotation annotation;

    protected Command() {
        this.annotation = WeaponImpl.class.getAnnotation(CustomAnnotation.class);
    }

    public String[] getParams() {
        return this.params;
    }

    public Repository<Weapon> getWeaponRepository() {
        return this.weaponRepository;
    }

    public CustomAnnotation getAnnotation() {
        return this.annotation;
    }
}
