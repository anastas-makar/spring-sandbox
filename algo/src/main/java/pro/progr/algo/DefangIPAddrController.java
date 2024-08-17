package pro.progr.algo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/defang_ip_addr")
public class DefangIPAddrController implements AlgoProblemInterface {

    @Override
    @GetMapping
    public String description() {
        return "Если указан действительный (IPv4) IP-адрес, верните defang версию этого IP-адреса.\n" +
                "\n" +
                "В defang IP-адресе каждая точка \".\" заменяется на \"[.]\". " +
                "(https://leetcode.com/problems/defanging-an-ip-address/description/)";
    }

    @GetMapping(params = "ip")
    public String solution(@RequestParam String ip) {
        return ip.replaceAll("\\.", "\\[\\.\\]");
    }
}
