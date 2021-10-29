集成我:

步骤 1.将 JitPack 存储库添加到您的构建文件

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
步骤 2.添加依赖项

	dependencies {
	        implementation 'com.github.HeVTion:CrashUtils:1.0.1'
	}
  
使用我:

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        CrashHandler.getInstance()
                .init(this) //初始化
                .setDebug(BuildConfig.DEBUG)//apk包是正式包还是测试包
                .setJumpError(true)//是否跳转指定页面
                .setCrashListener(ex -> {
                    ToastUtils.showLong("此处可以做一些上传操作");
                });//设置监听
    }
}
