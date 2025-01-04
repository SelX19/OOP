package week13.Task4;

public class ClientCode {
    public static void main(String[]args){

        NewDevice newDevice = new NewDeviceImpl();
        newDevice.operateNewFunction();

        OldDeviceImpl oldDevice = new OldDeviceImpl();

        //Using Device Adapter to adapt OldDevice to NewDevice:
        //NewDevice type, since adapter implements newDevice interface
        NewDevice adaptedDevice = new DeviceAdapter(oldDevice);
        adaptedDevice.operateNewFunction();
    }
}
