package _02Blobs.core.commands;

import _02Blobs.core.BaseCommand;
import _02Blobs.factories.AttackFactory;
import _02Blobs.factories.BehaviorFactory;
import _02Blobs.factories.BlobFactory;
import _02Blobs.interfaces.Attack;
import _02Blobs.interfaces.Behavior;
import _02Blobs.interfaces.Blob;

public class CreateCommand extends BaseCommand {
    @Override
    public String execute() {
        Behavior blobBehavior = BehaviorFactory.create(super.getParams()[4]);
        Attack blobAttack = AttackFactory.create(super.getParams()[5]);
        Blob blob = BlobFactory.createBlob(super.getParams()[1], Integer.parseInt(super.getParams()[2]),
                Integer.parseInt(super.getParams()[3]), blobBehavior, blobAttack);
        super.getRepository().add(blob);

        return null;
    }
}
