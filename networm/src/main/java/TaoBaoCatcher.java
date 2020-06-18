import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import org.jsoup.nodes.Document;

/**
 * @author: tangych
 * created on 2020/06/18
 **/
public class TaoBaoCatcher extends BreadthCrawler {
  public TaoBaoCatcher(String crawlPath, boolean autoParse) {
    super(crawlPath, autoParse);
    this.addSeed("https://www.taobao.com/");
    //this.addSeed("https://*");
    //this.addSeed("-.*\\.(jpg|png|gif).*");
  }

  public void visit(Page page, CrawlDatums crawlDatums) {
    String url =  page.url();
    System.out.println(url+"******************************************");
    if (page.matchUrl("https://.*")){
      System.out.println("************************************************");
      Document document = page.doc();
      page.select("a").forEach(element -> {
        System.out.println(element.text()+":"+element.attr("href"));
      });
    }
  }

  public static void main(String[] args) throws Exception {
    TaoBaoCatcher taoBaoCatcher = new TaoBaoCatcher("crawl",true);
    taoBaoCatcher.start(5);
  }
}
