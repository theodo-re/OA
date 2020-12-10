package cn.bdqn.oaproject;

import cn.bdqn.oaproject.controller.CarController;
import cn.bdqn.oaproject.entity.Users;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class OaprojectApplicationTests {

    @Test
    void contextLoads() {
        int[] num = {45,6,2,66,32,76};
        /*for(int i=0;i<num.length-1;i++){
            for(int j=0;j<num.length-i-1;j++){
                if(num[j]>num[j+1]){
                    int a=num[j];
                    num[j]=num[j+1];
                    num[j+1]=a;
                }
            }
        }
        for(int num1:num){
            System.out.println(num1);
        }*/
        /*for(int i=0;i<num.length-1;i++){
            int index=i;
            for (int j=i+1;j<num.length;j++){
                if(num[j]<num[index]){
                    index=j;
                }
            }
            int a=num[i];
            num[i]=num[index];
            num[index]=a;
        }
        for(int num1:num){
            System.out.print(num1+"    ");
        }*/

        for(int i=1;i<10;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+"*"+i+"="+(i*j)+"     ");
            }
            System.out.println();
        }
    }
}
