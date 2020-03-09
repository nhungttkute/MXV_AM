package com.newgen.am;

import com.google.gson.Gson;
import com.newgen.am.common.Utility;
import com.newgen.am.model.Broker;
import com.newgen.am.model.BrokerUser;
import com.newgen.am.model.Commodity;
import com.newgen.am.model.Company;
import com.newgen.am.model.Contact;
import com.newgen.am.model.Delegate;
import com.newgen.am.model.Individual;
import com.newgen.am.model.Investor;
import com.newgen.am.model.InvestorUser;
import com.newgen.am.model.LoginInvestorUser;
import com.newgen.am.model.MarginRatioAlert;
import com.newgen.am.model.Member;
import com.newgen.am.model.PositionLimit;
import com.newgen.am.model.RedisUserInfo;
import com.newgen.am.model.SystemRole;
import com.newgen.am.model.UserRole;
import com.newgen.am.repository.LoginInvestorUserRepository;
import com.newgen.am.repository.MemberRepository;
import com.newgen.am.repository.SystemRoleRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
public class Application {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MemberRepository memberRepo;
    @Autowired
    private SystemRoleRepository systemRoleRepo;
    @Autowired
    private LoginInvestorUserRepository invUserRepo;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CommandLineRunner demoData(MemberRepository userRepo) {
        // Insert new SystemRole
        SystemRole tvkdRole = new SystemRole();
        tvkdRole.setName("TVKD");
        tvkdRole.setDescription("Nhom quyen cho Thanh vien kinh doanh");
        tvkdRole.setStatus("ACTIVE");
        
        SystemRole mgRole = new SystemRole();
        mgRole.setName("MG");
        mgRole.setDescription("Nhom quyen cho Moi gioi");
        mgRole.setStatus("ACTIVE");
        
        SystemRole tkgdRole = new SystemRole();
        tkgdRole.setName("TKGD");
        tkgdRole.setDescription("Nhom quyen cho Tai khoan giao dich");
        tkgdRole.setStatus("ACTIVE");
        
        // Insert new Member
        Member member = new Member();
        member.setCode("001");
        member.setName("TVKD1");
        member.setNote("Testing TVKD1");
        member.setCompany(new Company());
        member.getCompany().setName("Newgen");
        member.getCompany().setRegistrationNumber("123456789");
        member.getCompany().setTaxCode("8888888");
        member.getCompany().setPhoneNumber("0912344566");
        member.getCompany().setFax("03667899000");
        member.getCompany().setEmail("newgen@gmail.com");
        member.getCompany().setAddress("1 Trang Tien, Hoan Kiem, Hanoi, VN");
        member.getCompany().setDelegate(new Delegate());
        member.getCompany().getDelegate().setFullName("Nguyen Dang Hung");
        member.getCompany().getDelegate().setBirthDay("01/01/1976");
        member.getCompany().getDelegate().setIdentityCard("288900055");
        member.getCompany().getDelegate().setIdCreatedDate("01/01/2010");
        member.getCompany().getDelegate().setIdCreatedLocation("Hanoi");
        member.getCompany().getDelegate().setEmail("danghung@gmail.com");
        member.getCompany().getDelegate().setPhoneNumber("0967383388");
        member.getCompany().getDelegate().setAddress("1 Trang Tien, Hoan Kiem, HN");
        member.setContact(new Contact());
        member.getContact().setFullName("Nguyen Dang Hung");
        member.getContact().setEmail("danghung@gmail.com");
        member.getContact().setPhoneNumber("0967383388");
        
        // Set roles for member
        UserRole tvkdRole2 = new UserRole();
        tvkdRole2.setId(1l);
        tvkdRole2.setName("TVKD");
        tvkdRole2.setDescription("Nhom quyen cho Thanh vien kinh doanh");
        tvkdRole2.setStatus("ACTIVE");
        List<UserRole> memberRoles = new ArrayList<>();
        memberRoles.add(tvkdRole2);
        member.setRoles(memberRoles);
        
        // Set position limit
        member.setPositionLimit(new PositionLimit());
        member.getPositionLimit().setPositionLimit(100);
        member.getPositionLimit().setOrderLimit(10);
        
        // Set new broker for member
        Broker broker = new Broker();
        broker.setId(1);
        broker.setCode("00001");
        broker.setName("Nguyen Van A");
        broker.setStatus("ACTIVE");
        broker.setType("INDIVIDUAL");
        broker.setBusinessType("INDIVIDUAL");
        broker.setCreatedAt(new Date());
        broker.setIndividual(new Individual());
        broker.getIndividual().setFullName("Nguyen Van A");
        broker.getIndividual().setBirthday("01/01/1990");
        broker.getIndividual().setIdentityCard("22334455");
        broker.getIndividual().setIdCreatedDate("01/01/2010");
        broker.getIndividual().setIdCreatedLocation("Hanoi");
        broker.getIndividual().setEmail("nguyen.van.a@gmail.com");
        broker.getIndividual().setPhoneNumber("09766554442");
        broker.getIndividual().setAddress("83B LTK, Hoan Kiem, Hanoi, VN");
        broker.setContact(new Contact());
        broker.getContact().setFullName("Nguyen Van A");
        broker.getContact().setPhoneNumber("09766554442");
        broker.getContact().setEmail("nguyen.van.a@gmail.com");
        
        // Set roles for broker
        UserRole mgRole2 = new UserRole();
        mgRole2.setName("MG");
        mgRole2.setDescription("Nhom quyen cho Moi gioi");
        mgRole2.setStatus("ACTIVE");
        List<UserRole> brokerRoles = new ArrayList<>();
        brokerRoles.add(mgRole2);
        broker.setRoles(brokerRoles);
        
        // Set user for broker
        broker.setUser(new BrokerUser());
        broker.getUser().setId(1);
        broker.getUser().setUsername("nguyenvana");
        broker.getUser().setPassword("Nguyen@123");
        broker.getUser().setPin("123456");
        broker.getUser().setFullName("Nguyen Van A");
        broker.getUser().setEmail("nguyen.van.a@gmail.com");
        broker.getUser().setPhoneNumber("09766554442");
        broker.getUser().setStatus("ACTIVE");
        broker.getUser().setIsPasswordExpiryCheck(Boolean.FALSE);
        broker.getUser().setCreatedAt(new Date());
        broker.getUser().setRoles(brokerRoles);
        
        // Set position limit
        broker.setPositionLimit(new PositionLimit());
        broker.getPositionLimit().setPositionLimit(50);

        // Set Investor for broker
        Investor investor = new Investor();
        investor.setId(1);
        investor.setCode("001C000001");
        investor.setName("Bui Thi Lien Huong");
        investor.setStatus("ACTIVE");
        investor.setType("LOCAL_INDIVIDUAL");
        investor.setIndividual(new Individual());
        investor.getIndividual().setFullName("Bui Thi Lien Huong");
        investor.getIndividual().setBirthday("01/01/1990");
        investor.getIndividual().setIdentityCard("1233444555");
        investor.getIndividual().setIdCreatedDate("01/01/2010");
        investor.getIndividual().setIdCreatedLocation("Hanoi");
        investor.getIndividual().setEmail("lien.huong@gmail.com");
        investor.getIndividual().setPhoneNumber("09123567778");
        investor.getIndividual().setAddress("1, Trang tien, Hoan Kiem, Hanoi");
        investor.setContact(new Contact());
        investor.getContact().setFullName("Bui Thi Lien Huong");
        investor.getContact().setPhoneNumber("09123567778");
        investor.getContact().setEmail("lien.huong@gmail.com");
        
         // Set roles for investor
        UserRole tkgdRole2 = new UserRole();
        tkgdRole2.setName("MG");
        tkgdRole2.setDescription("Nhom quyen cho Moi gioi");
        tkgdRole2.setStatus("ACTIVE");
        List<UserRole> investorRoles = new ArrayList<>();
        investorRoles.add(tkgdRole2);
        investor.setRoles(investorRoles);
        
        // Set position limit
        investor.setPositionLimit(new PositionLimit());
        investor.getPositionLimit().setPositionLimit(10);
        
        // Set margin ratio alert
        investor.setMarginRatioAlert(new MarginRatioAlert());
        investor.getMarginRatioAlert().setWarningRatio(80);
        investor.getMarginRatioAlert().setCancelOrderRatio(70);
        investor.getMarginRatioAlert().setFinalizationRatio(30);
        
        // Set margin multiplier
        investor.setMarginMultiplier(1.0);
        
        // Set user for investor
        InvestorUser user = new InvestorUser();
        user.setId(1);
        user.setUsername("newgen");
        user.setPassword("Newgen@123");
        user.setPin("123456");
        user.setFullName("Bui Thi Lien Huong");
        user.setEmail("lien.huong@gmail.com");
        user.setPhoneNumber("09123567778");
        user.setStatus("ACTIVE");
        user.setIsPasswordExpiryCheck(Boolean.FALSE);
        user.setCreatedAt(new Date());
        user.setRoles(investorRoles);
        
        List<InvestorUser> users = new ArrayList<>();
        users.add(user);
        
        investor.setUsers(users);
        
        List<Investor> investors = new ArrayList<>();
        investors.add(investor);
        
        broker.setInvestors(investors);
        
        List<Broker> brokers = new ArrayList<>();
        brokers.add(broker);
        member.setBrokers(brokers);
        
        LoginInvestorUser loginInvUser = new LoginInvestorUser();
        loginInvUser.setUsername("newgen");
        loginInvUser.setPassword(passwordEncoder.encode("Newgen@123"));
        loginInvUser.setCheckPin(Boolean.TRUE);
        loginInvUser.setPin("123456");
        loginInvUser.setMemberId(4);
        loginInvUser.setBrokerId(1);
        loginInvUser.setInvestorId(1);
        loginInvUser.setInvestorUserId(1);
        
        // Add commodities for member, broker, investor
        Commodity com1 = new Commodity();
        com1.setCode("LRC");
        com1.setName("Ca phe Robusta");
        com1.setPositionLimit(20);
        com1.setOrderProcessFee(200000l);
        
        Commodity com2 = new Commodity();
        com2.setCode("KCE");
        com2.setName("Ca phe Arabica");
        com2.setPositionLimit(20);
        com2.setOrderProcessFee(300000l);
        
        Commodity com3 = new Commodity();
        com3.setCode("ZME");
        com3.setName("Kho dau tuong");
        com3.setPositionLimit(20);
        com3.setOrderProcessFee(350000l);
        
        
        Commodity com4 = new Commodity();
        com4.setCode("ZLE");
        com4.setName("Dau dau tuong");
        com4.setPositionLimit(20);
        com4.setOrderProcessFee(400000l);
        
        Commodity com5 = new Commodity();
        com5.setCode("CLE");
        com5.setName("Dau WTI");
        com5.setPositionLimit(20);
        com5.setOrderProcessFee(500000l);
        
        List<Commodity> commodities = new ArrayList<>();
        commodities.add(com1);
        commodities.add(com2);
        commodities.add(com3);
        commodities.add(com4);
        commodities.add(com5);
        
        // add users to investor
        InvestorUser user2 = new InvestorUser();
        user2.setId(2);
        user2.setUsername("thanhdo");
        user2.setPassword("Thanhdo@123");
        user2.setPin("123456");
        user2.setFullName("Do Viet Thanh");
        user2.setEmail("thanh.do@gmail.com");
        user2.setPhoneNumber("093356677777");
        user2.setStatus("ACTIVE");
        user2.setIsPasswordExpiryCheck(Boolean.FALSE);
        user2.setCreatedAt(new Date());
        user2.setRoles(investorRoles);
        
        InvestorUser user3 = new InvestorUser();
        user3.setId(3);
        user3.setUsername("huongtra");
        user3.setPassword("Huongtra@123");
        user3.setPin("123456");
        user3.setFullName("Vu Huong Tra");
        user3.setEmail("huong.tra@gmail.com");
        user3.setPhoneNumber("093383899999");
        user3.setStatus("ACTIVE");
        user3.setIsPasswordExpiryCheck(Boolean.FALSE);
        user3.setCreatedAt(new Date());
        user3.setRoles(investorRoles);
        
        // insert into login_investor_users
        LoginInvestorUser loginInvUser2 = new LoginInvestorUser();
        loginInvUser2.setUsername("thanhdo");
        loginInvUser2.setPassword(passwordEncoder.encode("Thanhdo@123"));
        loginInvUser2.setCheckPin(Boolean.TRUE);
        loginInvUser2.setPin("123456");
        loginInvUser2.setMemberId(4);
        loginInvUser2.setBrokerId(1);
        loginInvUser2.setInvestorId(1);
        loginInvUser2.setInvestorUserId(1);
        
        LoginInvestorUser loginInvUser3 = new LoginInvestorUser();
        loginInvUser3.setUsername("huongtra");
        loginInvUser3.setPassword(passwordEncoder.encode("Huongtra@123"));
        loginInvUser3.setCheckPin(Boolean.TRUE);
        loginInvUser3.setPin("123456");
        loginInvUser3.setMemberId(4);
        loginInvUser3.setBrokerId(1);
        loginInvUser3.setInvestorId(1);
        loginInvUser3.setInvestorUserId(1);
        
        LoginInvestorUser loginInvUser4 = new LoginInvestorUser();
        loginInvUser4.setUsername("usertest1");
        loginInvUser4.setPassword(passwordEncoder.encode("Usertest@123"));
        loginInvUser4.setCheckPin(Boolean.TRUE);
        loginInvUser4.setPin("123456");
        loginInvUser4.setMemberId(4);
        loginInvUser4.setBrokerId(1);
        loginInvUser4.setInvestorId(1);
        loginInvUser4.setInvestorUserId(1);
        
        LoginInvestorUser loginInvUser5 = new LoginInvestorUser();
        loginInvUser5.setUsername("usertest2");
        loginInvUser5.setPassword(passwordEncoder.encode("Usertest@123"));
        loginInvUser5.setCheckPin(Boolean.TRUE);
        loginInvUser5.setPin("123456");
        loginInvUser5.setMemberId(4);
        loginInvUser5.setBrokerId(1);
        loginInvUser5.setInvestorId(1);
        loginInvUser5.setInvestorUserId(1);
        
        LoginInvestorUser loginInvUser6 = new LoginInvestorUser();
        loginInvUser6.setUsername("usertest3");
        loginInvUser6.setPassword(passwordEncoder.encode("Usertest@123"));
        loginInvUser6.setCheckPin(Boolean.TRUE);
        loginInvUser6.setPin("123456");
        loginInvUser6.setMemberId(4);
        loginInvUser6.setBrokerId(1);
        loginInvUser6.setInvestorId(1);
        loginInvUser6.setInvestorUserId(1);
        
        LoginInvestorUser loginInvUser7 = new LoginInvestorUser();
        loginInvUser7.setUsername("usertest4");
        loginInvUser7.setPassword(passwordEncoder.encode("Usertest@123"));
        loginInvUser7.setCheckPin(Boolean.TRUE);
        loginInvUser7.setPin("123456");
        loginInvUser7.setMemberId(4);
        loginInvUser7.setBrokerId(1);
        loginInvUser7.setInvestorId(1);
        loginInvUser7.setInvestorUserId(1);
        
        LoginInvestorUser loginInvUser8 = new LoginInvestorUser();
        loginInvUser8.setUsername("usertest5");
        loginInvUser8.setPassword(passwordEncoder.encode("Usertest@123"));
        loginInvUser8.setCheckPin(Boolean.TRUE);
        loginInvUser8.setPin("123456");
        loginInvUser8.setMemberId(4);
        loginInvUser8.setBrokerId(1);
        loginInvUser8.setInvestorId(1);
        loginInvUser8.setInvestorUserId(1);
        
        // test redis
        RedisUserInfo redisUser = new RedisUserInfo();
        redisUser.setDecryptedAccessToken("Nhung");
        redisUser.setValue("Tran Thi Nhung");
        
        return args -> {
//            systemRoleRepo.save(tvkdRole);
//            systemRoleRepo.save(mgRole);
//            systemRoleRepo.save(tkgdRole);
//            Member existedMember = memberRepo.findById(4l).get();
//            String jsonInStr = new Gson().toJson(existedMember);
//            System.out.println("memberJsonStr: " + jsonInStr);
//            JSONObject jsonObj = new JSONObject(existedMember);
//            String path = "/company/delegate";
//            JSONObject contactJsonStr = Utility.getNestedObjFromJsonObjectGivenKeys(jsonObj, Utility.extractKeys(path));
//            Contact contact = contactJsonStr.
//            System.out.println("contactJsonStr: " + contactJsonStr.getString("fullName"));
//            existedMember.getBrokers().get(0).getInvestors().get(0).getUsers().get;
//            existedMember.getBrokers().get(0).getInvestors().get(0).getUsers().add(user3);
//            existedMember.setComodities(commodities);
//            existedMember.setBrokers(brokers);
//            memberRepo.save(existedMember);
//            
//            invUserRepo.save(loginInvUser4);
//            invUserRepo.save(loginInvUser5);
//            invUserRepo.save(loginInvUser6);
//            invUserRepo.save(loginInvUser7);
//            invUserRepo.save(loginInvUser8);
            
            //Test redis
//            redisUserInfoRepo.save(redisUser);
//            RedisUserInfo existedRedisUserInfo = redisUserInfoRepo.findById("Nhung").get();
//            System.out.println("User Value: " + existedRedisUserInfo.getValue());
        };
        
//        return args -> {
//            for (int j = 0; j <= 1000; j++) {
//                int i = r.nextInt(1001);
//                String username = "test" + i;
//                String password = "password";
//                String firstName = "UserTest" + i;
//                String lastName = "Nguyen";
//                userRepo.save(new User(username, passwordEncoder.encode(password), firstName, lastName));
//            }
//        };
    }
    
//    @Bean
//    public CommandLineRunner demoData(JwtTokenProvider tokenProvider) {
//        return args -> {
//            String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOlt7ImF1dGhvcml0eSI6IlJPTEVfQ0xJRU5UIn1dLCJpYXQiOjE1NzkwODI1NjMsImV4cCI6MTU3OTA4NjE2M30.ZYgBh-PMy-6uGZ9DDhS3pTcs4j_E0jjV6jFTHwen5cM";
//            SimpleDateFormat fomater = new SimpleDateFormat("dd/MM/yyyy HH:mm:SS");
//            System.out.println("ExpiryDate: " + fomater.format(tokenProvider.getExpiration(token)));
//        };
//    }
}
