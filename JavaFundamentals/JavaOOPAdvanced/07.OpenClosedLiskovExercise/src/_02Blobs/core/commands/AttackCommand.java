package _02Blobs.core.commands;

import _02Blobs.core.BaseCommand;
import _02Blobs.interfaces.Blob;

public class AttackCommand extends BaseCommand {
    @Override
    public String execute() {
        if (super.getRepository().findByName(super.getParams()[1]) != null &&
                super.getRepository().findByName(super.getParams()[2]) != null ){
            Blob attacker = super.getRepository().findByName(super.getParams()[1]);
            Blob target = super.getRepository().findByName(super.getParams()[2]);

            attacker.attack(target);
        }

        return null;
    }
}
