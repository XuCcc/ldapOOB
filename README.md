# LDAP OOB Server

> 用来验证 JNDI LDAP 注入
>
> CVE-2021-44228: Log4j2 remote code exec

## Usage

启动 `java -jar ldap-oob.jar`

### API

- 获取标识id：`GET http://127.0.0.1:8080/ldap/register` -> `id`
- 判断标识id是否被ldap触发 `GET http://127.0.0.1:8080/ldap/{id}/access` -> `boolean`
- 删除标识id: `POSTS http://127.0.0.1:8080/ldap/{id}/unregister`

### LDAP

`ldap://127.0.0.1:31389/{id}`