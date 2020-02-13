package br.com.como_voce_mora.model;


public enum AboutYouAnswer {
    WHATS_YOUR_GENDER("Qual é o seu genero?", "60024160-4e66-44b3-9572-75a409685000"),
    WHATS_YOUR_AGE("Quantos anos você tem", "587f357b-8172-490d-a114-69da4109098f"),
    SCHOOLING("Até que ano da escola você cursou?", "95a92625-6ad9-4763-948a-aafff913d33d"),

    NUMBER_OF_PERSON("Agora vamos falar sobre os moradores. Selecione quem mora com você.", "2d40a340-1cc7-4d88-b9e5-f39404463c3b"),
    DOUGTHER("Filha", "590b5fd61e4d3f620eea2782"),
    SON("Filho", "590b5fd61e4d3f620eea2783"),
    WIFE("Esposa / Parceira", "590b5fd61e4d3f620eea2784"),
    HUSBAND("Esposo / Parceiro", "590b5fd61e4d3f620eea2785"),
    MOTHER("Mãe", "590b5fd61e4d3f620eea2786"),
    FATHER("Pai", "590b5fd61e4d3f620eea2787"),
    GRANDFATHER("Avô", "590b5fd61e4d3f620eea2788"),
    GRANDMOTHER("Avó", "590b5fd61e4d3f620eea2789"),
    FRIEND("Amigo (a) / Colega", "590b5fd61e4d3f620eea278a"),
    BROTHER("Irmão", "590b5fd61e4d3f620eea278b"),
    SISTER("Irmã", "590b5fd61e4d3f620eea278c"),
    OTHER_RELATIVE("Outro Parente", "590b5fd61e4d3f620eea278d"),
    PET("Animal de Estimação", "590b5fd61e4d3f620eea278e"),


    WORK_FOR_YOU_YES("Trabalha algum funcionário em sua moradia?", "22384438-6b03-4500-9ebe-e376850de737"),
    WORK_FOR_YOU_NO("Trabalha algum funcionário em sua moradia?", "0d70117e-9901-476b-9cdb-339e3456cea3"),


    FAMILY_FIANNCE("Qual sua renda familiar (em Reais)?", "92a177d9-27a6-4a21-a193-8ebe3fe556fb"),
    EMPLOYEE_TYPE("Se algum funcionário trabalha em sua casa, qual o tipo de contrato?", "74965001-7420-42a6-9ac6-cab586482ec4"),
    WHATS_YOUR_PROFESSION("Qual é sua atividade principal?", "408f937b-2e42-4fae-ade5-b246771bc7ef"),
    FAMILY_INCOME("Qual sua renda familiar em reais? Lembre-se que é a renda de todos os moradores\n" +
        "somada. Se você não souber ou quiser responder, apenas clique em avançar","216db099-3479-4dca-955a-d47275fe6813");


    String question;
    String questionPartId;

    AboutYouAnswer(String question, String questionPartId) {
        this.question = question;
        this.questionPartId = questionPartId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionPartId() {
        return questionPartId;
    }

    public void setQuestionPartId(String questionPartId) {
        this.questionPartId = questionPartId;
    }
}