function fn() {
  karate.configure('connectTimeout', 50000);
  karate.configure('readTimeout', 50000);
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev';
  }
 var config = {
        env: env,
        testConfig:   'bar',
        urlApi:       'url',
        datajson:     'json',
        var_headers:  {'Authorization:': 'Bearer Bearer 05b32125-8b3a-4827-9954-b8049d74da26'}
    }
    switch (env){
        case "dev":
        config.urlApi     = 'https://petstore.swagger.io/v2';
        config.datajson   = 'dev';
        break;

  }
  return config;
}