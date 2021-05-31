//import com.teamdev.jxbrowser.browser.Browser;
//import com.teamdev.jxbrowser.dom.InputElement;
//import com.teamdev.jxbrowser.dom.Node;
//import com.teamdev.jxbrowser.engine.Engine;
//import com.teamdev.jxbrowser.engine.EngineOptions;
//import com.teamdev.jxbrowser.engine.RenderingMode;
//import com.teamdev.jxbrowser.view.swing.BrowserView;
//import com.teamdev.jxbrowser.frame.Frame;
//
//public class JXBrowser {
//
//    private static final RenderingMode HARDWARE_ACCELERATED = RenderingMode.HARDWARE_ACCELERATED;
//
//    private Engine engine;
//    private String htmlFile;
//    public Browser browser;
//    public BrowserView view;
//
//    JXBrowser() {
//        this.engine = Engine.newInstance(
//                EngineOptions.newBuilder(HARDWARE_ACCELERATED)
//                        .licenseKey("1BNDHFSC1FZ7ZZCU2Y1OPJOXDKVS1TVAWRPQMGTFV98ADATIG5YXAXODH1O5IUVC03P6ZX")
//                        .build());
//        this.browser = engine.newBrowser();
//        this.view = BrowserView.newInstance(browser);
//        this.htmlFile = "/home/yawgmoth/Dropbox/HU-ADSD/S1/Periode1/OV-app/src/index.html";
//    }
//
//    public void loadUrl() {
//        browser.navigation().loadUrl(htmlFile);
//        System.out.println("HTML file loaded");
//    }
//
//
//    public void drawMap(String searchLocationA, String searchLocationB) {
//        browser.mainFrame().flatMap(Frame::document).ifPresent(document -> {
//            String baseUri = document.baseUri();
//
//            System.out.println(searchLocationA);
//            System.out.println(searchLocationB);
//
//
//            document.findElementById("departure").ifPresent(element -> ((InputElement) element).value(searchLocationA));
//            document.findElementById("destination").ifPresent(element -> ((InputElement) element).value(searchLocationB));
//        });
//    }
//
//
//}