public enum API {
    
    IMDB_TOP_MostPopularTVs(//"https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json"
    "http://localhost:8080/linguagens", new ExtratorDeConteudoDoIMDB()),
    NASA("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json", new ExtratorDeConteudoDaNasa());

    private String url;
    private ExtratorDeConteudo extrator;

    API(String url, ExtratorDeConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public ExtratorDeConteudo getExtrator() {
        return extrator;
    }

    
    
}
