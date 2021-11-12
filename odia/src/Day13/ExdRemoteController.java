package Day13;

public interface ExdRemoteController {
	public void powerOn();
	public void powerOff();

}

interface ExdTvRemoteController extends ExdRemoteController{
	public void powerOn();
	public void powerOff();
	public void volumnUp();
	public void volumnDown();
	public void channelUp();
	public void channelDown();
	public void changeChannel(int num);
}
class ExdTvRemoteCon implements ExdTvRemoteController{

	private boolean power = false; //tv전원상태
	private int channel = 1 ; //채널(임의의 채널)
	private int volumn = 0; //볼륨값(임의)
	private final int maxChannel;
	private final int maxVolumn;
	
	@Override
	public void powerOn() {
		power = true ;
		System.out.println("전원이 켜졌습니다.");
	}
	
	@Override
	public void powerOff() {
		power = false;
		System.out.println("전원이 꺼집니다.");
	}

	
	@Override
	public void volumnUp() {
		//tv가 꺼져 있으면 소리 올리지 마세요
		if(!power) {
			return;
		}
		++volumn;
		volumn = volumn > maxVolumn ? maxVolumn : volumn;
		/*if(volumn > maxVolumn) { //if 조건문과 같은 내용을
			volumn = maxVolumn; //단순하게 표현
		}*/
		System.out.println("소리 : " + volumn);
	}

	@Override
	public void volumnDown() {
		if(!power) {
			return;
		}
		--volumn;
		volumn = volumn < 0 ? 0 : volumn;
		/*if(volume < 0){
		    volumn = 0; 
		 }*/
		System.out.println("소리 : " + volumn);
	}
	

	@Override
	public void channelUp() {
		if(!power) {
			return;
		}
		++channel;
		channel = channel > maxChannel ? maxChannel : channel;
		System.out.println("채널 : "+channel);
		
	}

	@Override
	public void channelDown() {
		if(!power) {
			return;
		}
		--channel;
		channel = channel < 0 ? 0 : channel;
		System.out.println("채널 : "+channel);
	}

	@Override
	public void changeChannel(int num) {
		if(!power) {
			return;
		}
		channel = maxChannel < num ? maxChannel : num;
		System.out.println("채널 : " +channel);
		
	}
	public ExdTvRemoteCon(int maxVolumn, int maxChannel) {
		this.maxChannel = maxChannel;
		this.maxVolumn = maxVolumn;
	}
}
class ExdLGTvRemoteCon extends ExdTvRemoteCon{
	public final static String Logo = "LG";
	public ExdLGTvRemoteCon(int maxVolumn, int maxChannel) {
		super(maxVolumn, maxChannel);
	}
}
class ExdSamSungTvRemoteCon extends ExdTvRemoteCon{
	public final static String Logo = "SAMSUNG";
	public ExdSamSungTvRemoteCon(int maxVolumn, int maxChannel) {
		super(maxVolumn, maxChannel);
	}
}