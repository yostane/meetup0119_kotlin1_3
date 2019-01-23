
// workaround
class Ken implements StreetFighter{
    @Override
    public int getBaseHp() {
        return DefaultImpls.getBaseHp(this);
    }
}

public class annotations_09b2 {
}
