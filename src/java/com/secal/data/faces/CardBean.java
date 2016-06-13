package com.secal.data.faces;

import com.bank.service.AccountLimit;
import com.bank.service.BalanceUpdate;
import com.bank.service.BalanceUpdateService;
import com.bank.service.Controller;
import com.bank.service.ControllerService;
import com.secal.data.entity.Satis;
import com.secal.data.entity.Card;
import com.secal.data.entity.Product;
import com.secal.data.entity.User;
import com.secal.data.repository.CardRepository;
import com.secal.data.repository.ProductRepository;
import com.secal.data.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * // 1 - Product'u ProductEmbeded ile değiştir, veya sadece id2ler tut
 * sepette, // 2 - aynı anda sepet listesi oluştur. listedeki her eleman için
 * tek bir alan olucak, // hemen yanında kaç adet olduğu yazılıcak-toplam
 * ödenecek lira yazıcak.-tıklanınca view'e gidicek // 3 - Sonra banka diye bi
 * tablo olucak her satın almada sorgu atılıp kartın limiti varmı yokmu kontrol
 * edilicek // 4 - sonra geri iade prosedürü olucak, satın almadan hemen sonra
 * vazgeç seçeneği olucak, tıklandığı vakit, // çeşitli güvenlik işlemlerinden
 * sonra iade başarıyla yaptırılıcak. // 5 - satın alındıktan sonra, user için
 * satın aldıklarım sekmesi olucak db'den satis listesini getiricek. // 6 - ilan
 * olayı olucak, her user kendi ürününü sisteme ekleyip listeleyebilicek, // 7 -
 * site ilk açıldığında solda seçenekler-ortada tüm ürünler-sağda boş-üstte
 * anasayfa search vs-alt sayfa geçiş olucak // her sayfaya 5-10-20 şeklinde
 * seçenekli olarak ürünler gelicek // ürün sayısına göre sayfa sayısı olup
 * altta sayfadan-sayfaya geçiş linkleri sayfa rakamı şeklinde olucak.
 *
 * // 8 - Hepsi için PrimeFaces ile mock-up yazıcaz. Hepsi Tamamlandıktan
 * sonra, // 9 - Tüm bunlar için Business moda geçicez. Hepsini Business modda
 * yazıcaz. // 10 - Üstüne Tüm Eksikler tek tek kontrol edilip toparlanıp
 * düzeltilicek- site tamamlanıcak. // Tüm gereksiz ve algoritma mantığı kötü
 * olan yerler ayıklanıp düzeltilicek // Her Aşama için proje ayrı ayrı
 * kaydedilip - gelişim aşamaları takipte olucak. // 11 - En son tüm imla-vurgu
 * eksik/yanlışları düzeltilicek.
 *
 * // Product tipini ProductEmbeded ile değiş. // EKSİK KALDI.
 *
 * // İlk olarak adet olayını ve tutar olayını düzelt. // sonra cinsiyet
 * sınıfını bağla. // ** ** ** Tamamen sahibinden.com benzeri bir hale dönüşsün.
 * // yavaş yavaş tüm kaba eksikleri giderelim. // sonra tüm ince detayları
 * giderelim. // ** Business katmana geçirelim // ** Primefaces kullanalım.
 */
@ManagedBean
@ApplicationScoped
public class CardBean {

    ProductRepository productRepo;
    CardRepository cardRepo;
    UserRepository userRepo;

    private List<Product> sepetProductList;
    private List<Product> tmpProductList;

    private Satis satis;
    private Card card;
    private User user;
    private boolean sepetVarMi;
    private int totalPay;

    public CardBean() {
        System.out.println("CardBean'den Geçti");
        productRepo = new ProductRepository();
        cardRepo = new CardRepository();
        userRepo = new UserRepository();

        sepetProductList = new ArrayList<>();
        tmpProductList = new ArrayList<>();
        user = new User();
        card = new Card();
    }

    private void sepetKontrol() {
        if (!sepetProductList.isEmpty()) {
            sepetVarMi = true;
        } else {
            sepetVarMi = false;
        }
    }

    public void sepeteEkle() {
        productRepo = new ProductRepository();
        long productId = 0;
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        if (request.getParameter("productId") != null) {
            productId = new Long(request.getParameter("productId"));
        }
        Product product = productRepo.find(productId);
        productRepo.close();

        tmpProductList.add(product);
        // Burdan kaç adet olduğu gelir.
        int count = 0;
        for (Product tmpPro : tmpProductList) {
            if (tmpPro.getProductId() == product.getProductId()) {
                count++;
            }
        }
        product.setTotalNumber(count);
        product.setTotalCost(count * product.getSalesPrice());
        if (!sepetProductList.isEmpty()) {
            boolean isSet = false;
            for (int i = 0; i < sepetProductList.size(); i++) {
                Product pro = sepetProductList.get(i);
                if (pro.getProductId() == product.getProductId()) {
                    sepetProductList.set(i, product);
                    isSet = true;
                }
            }
            if (!isSet) {
                sepetProductList.add(product);
            }
        } else {
            product.setTotalNumber(count);
            product.setTotalCost(count * product.getSalesPrice());
            sepetProductList.add(product);
        }

        sepetKontrol();
    }

    public void adetAzalt() {
        productRepo = new ProductRepository();
        long productId = 0;
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        if (request.getParameter("productId") != null) {
            productId = new Long(request.getParameter("productId"));
        }
        Product product = productRepo.find(productId);
        productRepo.close();

        for (Product tmpPro : tmpProductList) {
            if (tmpPro.getProductId() == product.getProductId()) {
                tmpProductList.remove(tmpPro);
                break;
            }
        }
        // Burdan kaç adet(count) olduğu gelir.
        int count = 0;
        for (Product tmpProduct : tmpProductList) {
            if (tmpProduct.getProductId() == product.getProductId()) {
                count++;
            }
        }
        for (int i = 0; i < sepetProductList.size(); i++) {
            Product pro = sepetProductList.get(i);
            if (pro.getProductId() == product.getProductId()) {
                if (count != 0) {
                    product.setTotalNumber(count);
                    product.setTotalCost(count * product.getSalesPrice());
                    sepetProductList.set(i, product);
                } else if (count == 0) {
                    sepetProductList.remove(pro);
                }
                break;
            }
        }

        sepetKontrol();
    }

    public void sepettenCikar() {
        productRepo = new ProductRepository();
        List<Product> list = new ArrayList<>();
        long productId = 0;
        int adet = 0;
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        if (request.getParameter("productId") != null) {
            productId = new Long(request.getParameter("productId"));
        }
        Product product = productRepo.find(productId);
        productRepo.close();
        // list oluşturulur
        for (int i = 0; i < tmpProductList.size(); i++) {
            Product pro = tmpProductList.get(i);
            if (pro.getProductId() == product.getProductId()) {
                list.add(pro);
            }
        }
        // Burdan bir üründen kaç adet olduğu bilgisi gelir.
        adet = list.size();

        // tmpProductList güncellenir
        for (Product pro : list) {
            for (int i = 0; i < tmpProductList.size(); i++) {
                if (pro.getProductId() == tmpProductList.get(i).getProductId()) {
                    tmpProductList.remove(tmpProductList.get(i));
                }
            }
        }
        // Ürün sepetProductList' den çıkarılır
        for (int i = 0; i < sepetProductList.size(); i++) {
            Product pro = sepetProductList.get(i);
            if (pro.getProductId() == product.getProductId()) {
                pro.setTotalNumber(0);
                pro.setTotalCost(0);
                sepetProductList.remove(pro);
                break;
            }
        }

        sepetKontrol();
    }

    public String sepetiTemizle() {
        sepetProductList.clear();
        tmpProductList.clear();
        return "Home?faces-redirect=true";
    }

    public int toplamTutar() {
        totalPay = 0;
        for (Product product : sepetProductList) {
            totalPay += product.getTotalCost();
        }
        return totalPay;
    }

    public void satisiTamamla() {
        // Burada Satışı tamamlayabilmek için, Bankaya Bağlanıp Kartın limiti felan kontrol edilmeli
        // Normalde bir banka kontrolü için, önce ilk handler'a gidilir, handler telefona bi sms atar
        // sonra o handlerin attığı smsteki kod doğru girilirse (3 defa girme hakkıyla) 
        // Handler gider Ticket servisine ordan bi header keyi alır headera eklenir
        // Bu header keyinde Hangi Banka'nın servisine gidilmesi gerektiği bilgisi eklenebilir (Örnek durum)

        // ordan sonra bu header key ile Sistemin BankaKontrolServis Handler'ına gidilir,
        // Bu Handler gelen keye bakıp ilgili Servise yönlendirir.
        // Ordanda geçiş tamamlanınca, Bankanın servisine bağlanıp sorgu yapılır ve 
        // Doğru sonuç bilgisini alınır.
        // Bizim BankaKontrolServisimiz ise, Her bankanın servisi BankaKontrolServisi içindeymiş gibi,
        // Handler sistemi olmadan direkt servis görevi görüp, Kim hangi bankada kayıtlıysa, onun
        // gerekli (limitCard vs..) bilgilerini verir.
        productRepo = new ProductRepository();
        cardRepo = new CardRepository();
        //- - - - Her Seçilen Product için Satış Kaydı Ayarlanır. - - - -//

        ControllerService service = new ControllerService();
        Controller servicePort = service.getControllerPort();
        AccountLimit limitCard = servicePort.lookLikeBalance(card.getCardNumber());
        if (limitCard != null && limitCard.getBalanceCard() >= totalPay) {
            for (Product product : sepetProductList) {

                // Card Satış Listesi için Yer Açılır.
                card.setSatisList(new ArrayList<>());
                // Satış için yer, 
                satis = new Satis();
                // Satiş için gerekli alanlar product'ten alınıp set edilir.
                satis.setProductId(product.getProductId());
                satis.setSatisAdet(product.getTotalNumber());
                satis.setToplamTutar(product.getTotalCost());
                satis.setBirimFiyat(product.getSalesPrice());
                // Satış'ın Card alanı için yer - - Açılır - -
                satis.setCard(card);
                // Card'ın Satış Listesine Teker Teker Satış eklenir.
                card.getSatisList().add(satis);
                // Card'ın Banka Adı Girilir.
                card.setNameOf_Bank(limitCard.getNameOfBank());

                // Card Kaydı Yapılır. Bu Sayede Aynı Anda Satış Kaydı da yapılır.
                cardRepo.persist(card);

                // Satılan Her Ürün İçin Product'den 1 adet düşülür.
                product.setProductQuantity(product.getProductQuantity() - product.getTotalNumber());
                productRepo.merge(product);

                // Uzaktaki servise bağlanıp kişinin kredi kart hesabının bakiyesinden,
                // fatura tutatı düşürülür.
            }
            BalanceUpdateService balanceService = new BalanceUpdateService();
            BalanceUpdate balancePort = balanceService.getBalanceUpdatePort();
            balancePort.getUpdateBalance((int) card.getCardNumber(), totalPay);
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage("Tebrikler! ürünü/ürünleri başarıyla satın aldınız."));
        } else if (limitCard == null) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage("Geçersiz Kart Numarası Girdiniz! "
                            + "Lütfen Tekrar Deneyiniz"));
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage("Hesap bakiyeniz yetersiz! "
                            + "Lütfen varsa başka bir kredi kartı ile deneyin."
                            + "( Bakiyeniz : " + limitCard.getBalanceCard() + ")"));
        }

        productRepo.close();
        cardRepo.close();
    }

    public String goCheckOut() {
        userRepo = new UserRepository();

        long userId = 0;
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();

        if (request.getParameter("userId") != null) {
            userId = Long.parseLong(request.getParameter("userId"));
        }
        if (userId != 0) {
            if (session.getAttribute("nickName") != null) {
                String nickname = (String) session.getAttribute("nickName");
                user = userRepo.findByNickname(nickname);
                userRepo.close();
                card.setCustomerName(user.getUserName());
            }
        }
        return "CheckOut?faces-redirect=true";
    }

    //<editor-fold defaultstate="collapsed" desc="Getter ve Setter">
    public void setSepetVarMi(boolean sepetVarMi) {
        this.sepetVarMi = sepetVarMi;
    }

    public boolean isSepetVarMi() {
        return sepetVarMi;
    }

    public Satis getSatis() {
        return satis;
    }

    public void setSatis(Satis satis) {
        this.satis = satis;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setSepetProductList(List<Product> sepetProductList) {
        this.sepetProductList = sepetProductList;
    }

    public List<Product> getSepetProductList() {
        return sepetProductList;
    }

    public int getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(int totalPay) {
        this.totalPay = totalPay;
    }

//</editor-fold>
}
