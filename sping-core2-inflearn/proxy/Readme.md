# Proxy
- TheadLocal
- 디자인 패턴
    > TemplateMethod  
  > Proxy  
  > Decorator  
  > Strategy
  > Template Callback
- JDK 동적 프록시
- CGLIB
- Proxy Factory Pattern
    > `/src/test/**/common/advice/*`  
     `/src/test/**/proxyfactory/*`
- 포인트컷, 어드바이스, 어드바이저
    > `/src/test/**/advisor/*`  
  > `/src/main/**/v3_proxyfactory/*`  
- 빈 후처리기
    > `/src/main/**/v4_postprocessor/*`
- spring에서 제공하는 빈 후처리기
    > `/src/main/**/v5_autoproxy/*`