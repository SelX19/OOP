package week13.Task4;

//adapter class
public class DeviceAdapter implements NewDevice{

    /*The adapter should wrap an instance of OldDeviceImpl,
    and provide a translation mechanism to make it compatible with the NewDevice interface.*/

    OldDevice oldDevice = new OldDeviceImpl();

    public DeviceAdapter(OldDevice oldDevice){
        this.oldDevice=oldDevice;
    }


    @Override
    public void operateNewFunction(){
        System.out.println("Adapting old device to new device...");
        oldDevice.operateOldFunction();
    }

}
