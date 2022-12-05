package DiContainer.Interfaces.Builder;

public interface IBindingScope 
{
    ILazyBinding AsSingle();
    void AsTransient();
}
