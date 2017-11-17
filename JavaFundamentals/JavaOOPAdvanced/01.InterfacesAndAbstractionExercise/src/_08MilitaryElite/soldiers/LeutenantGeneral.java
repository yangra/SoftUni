package _08MilitaryElite.soldiers;

import _08MilitaryElite.interfaces.ILeutenantGeneral;
import _08MilitaryElite.interfaces.IPrivate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {
    private List<IPrivate> privates;

    public LeutenantGeneral(String id, String firstName, String lastName, double salary, List<IPrivate> privates) {
        super(id, firstName, lastName, salary);
        this.privates = privates;
    }

    @Override
    public List<IPrivate> getPrivates() {
        return Collections.unmodifiableList(this.privates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());

        sb.append("Privates:").append(System.lineSeparator());
        if (this.privates.size() > 0) {
            List<IPrivate> sorted = this.privates.stream()
                    .sorted(Comparator.comparing(IPrivate::getId).reversed())
                    .collect(Collectors.toList());

            int count = 0;
            for (IPrivate iprivate : sorted) {
                sb.append("  ").append(iprivate.toString()).append(System.lineSeparator());
                count++;
            }
        }

        return sb.toString();
    }
}
