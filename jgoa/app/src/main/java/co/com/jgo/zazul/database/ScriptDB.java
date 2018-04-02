package co.com.jgo.zazul.database;

import android.provider.BaseColumns;


public class ScriptDB {

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String IMAGE_TYPE = " IMAGE";
    private static final String DATE_TYPE = " DATE";
    private static final String BLOB_TYPE = " BLOB";
    private static final String COMMA_SEP = ", ";

    private ScriptDB() {}

    // ***  CONFIGURATION *** //

    public static class ConfiguracaoEntry implements BaseColumns {
        public static final String TABLE_NAME = "configuracao";
        public static final String COLUMNcodigoCONFIGURATION = "codigo";
        public static final String COLUMN_portaria = "portaria";
        public static final String COLUMN_tempo_gps = "tempo_gps";
        public static final String COLUMN_tempo_gps_envio = "tempo_gps_envio";
        public static final String COLUMN_tempo_inativo="tempo_inativo";
        public static final String COLUMN_criptografia = "criptografia";
        public static final String COLUMN_amarra = "amarra";
    }

    public static final String CREATE_CONFIGURACAO =
            "CREATE TABLE "  +" IF NOT EXISTS " + ConfiguracaoEntry.TABLE_NAME + " (" +
                    ConfiguracaoEntry.COLUMNcodigoCONFIGURATION + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    ConfiguracaoEntry.COLUMN_portaria + TEXT_TYPE + COMMA_SEP +
                    ConfiguracaoEntry.COLUMN_tempo_gps + TEXT_TYPE +COMMA_SEP +
                    ConfiguracaoEntry.COLUMN_tempo_gps_envio + TEXT_TYPE +COMMA_SEP +
                    ConfiguracaoEntry.COLUMN_tempo_inativo +TEXT_TYPE + COMMA_SEP +
                    ConfiguracaoEntry.COLUMN_criptografia + TEXT_TYPE + COMMA_SEP +
                    ConfiguracaoEntry.COLUMN_amarra + TEXT_TYPE + " )";


    // *** CLIENTE TABLE *** //
    public static class ClienteEntry implements BaseColumns {
        public static final String TABLE_NAME = "cliente";
        public static final String COLUMN_NAME_CODCliente = "codigo";
        public static final String COLUMN_url_rastreio = "url_rastreio";
        public static final String COLUMN_url_infracao = "url_infracao";
        public static final String COLUMN_url_tabelas = "url_tabelas";
        public static final String COLUMN_url_consultas = "url_consultas";
        public static final String COLUMN_NAME_NOMEcliente = "nome";
        public static final String COLUMN_NAME_id_cidade = "id_cidade";

    }
    public static final String CREATE_CLIENTE =
            "CREATE TABLE " +" IF NOT EXISTS "+ ClienteEntry.TABLE_NAME + " (" +
                    ClienteEntry.COLUMN_NAME_CODCliente + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    ClienteEntry.COLUMN_NAME_NOMEcliente + TEXT_TYPE + COMMA_SEP +
                    ClienteEntry.COLUMN_url_rastreio + TEXT_TYPE + COMMA_SEP +
                    ClienteEntry.COLUMN_url_infracao + TEXT_TYPE + COMMA_SEP +
                    ClienteEntry.COLUMN_url_tabelas + TEXT_TYPE + COMMA_SEP +
                    ClienteEntry.COLUMN_url_consultas + TEXT_TYPE + COMMA_SEP +
                    ClienteEntry.COLUMN_NAME_id_cidade + TEXT_TYPE + COMMA_SEP +


                    "FOREIGN KEY"+ " (" + ClienteEntry.COLUMN_NAME_id_cidade + ") " + "REFERENCES " + CidadeEntry.TABLE_NAME
                    +" ("+ CidadeEntry.COLUMN_NAME_codigo +") "+
                    ") ";


    // *** CIDADE TIPO_IDENDIDADE *** //

    public static class Tipo_IdentidadeEntry implements BaseColumns {
        public static final String TABLE_NAME = "tipo_idendidade";
        public static final String COLUMNTIPO_IDENDIDADE = "codigo";
        public static final String COLUMN_nome = "nome";

    }

    public static final String CREATE_TIPO_IDENDIDADE =
            "CREATE TABLE "  +" IF NOT EXISTS " + Tipo_IdentidadeEntry.TABLE_NAME + " (" +
                    Tipo_IdentidadeEntry.COLUMNTIPO_IDENDIDADE + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    Tipo_IdentidadeEntry.COLUMN_nome + TEXT_TYPE +
                    " )";

    // *** MODULO TABLE *** //

    public static class MODULOEntry implements BaseColumns {
        public static final String TABLE_NAME = "modulo";
        public static final String COLUMN_codigo = "codigo";
        public static final String COLUMN_nome = "nome";
        public static final String COLUMN_imagem = "imagem";
        public static final String COLUMN_cor = "cor";
    }

    public static final String CREATE_MODULO =
            "CREATE TABLE "  +" IF NOT EXISTS " + MODULOEntry.TABLE_NAME + " (" +
                    MODULOEntry.COLUMN_codigo + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    MODULOEntry.COLUMN_nome + TEXT_TYPE + COMMA_SEP +
                    MODULOEntry.COLUMN_imagem + TEXT_TYPE + COMMA_SEP +
                    MODULOEntry.COLUMN_cor + TEXT_TYPE +
                    " )";


    // *** PERFIL TABLE *** //

    public static class PerfilEntry implements BaseColumns {
        public static final String TABLE_NAME = "perfil";
        public static final String COLUMN_NAME_CodPerfil = "codigo";
        public static final String COLUMN_NAME_NOMEPerfil = "nome";
    }

    public static final String CREATE_PERFIL =
            "CREATE TABLE "  +" IF NOT EXISTS " + PerfilEntry.TABLE_NAME + " (" +
                    PerfilEntry.COLUMN_NAME_CodPerfil + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    PerfilEntry.COLUMN_NAME_NOMEPerfil + TEXT_TYPE  +
                    " )";


    // *** PERFIL_MODULO TABLE *** //

    public static class PERFIL_MODULOEntry implements BaseColumns {
        public static final String TABLE_NAME = "perfil_modulo";
        public static final String COLUMN_codigo_perfil = "codigo_perfil";
        public static final String COLUMN_codigo_modulo = "codigo_modulo";
    }

    public static final String CREATE_PERFIL_MODULO =
            "CREATE TABLE "  +" IF NOT EXISTS " + PERFIL_MODULOEntry.TABLE_NAME + " (" +
                    PERFIL_MODULOEntry.COLUMN_codigo_perfil + INTEGER_TYPE  + COMMA_SEP +
                    PERFIL_MODULOEntry.COLUMN_codigo_modulo + INTEGER_TYPE + COMMA_SEP +
                    "FOREIGN KEY" + " (" + PERFIL_MODULOEntry.COLUMN_codigo_perfil + ") " + " REFERENCES " + PerfilEntry.TABLE_NAME + " (" + PerfilEntry.COLUMN_NAME_CodPerfil + ") " + COMMA_SEP +
                    "FOREIGN KEY" + " (" + PERFIL_MODULOEntry.COLUMN_codigo_modulo + ") " + " REFERENCES " + MODULOEntry.TABLE_NAME + " (" + MODULOEntry.COLUMN_codigo + ") " + COMMA_SEP +
                    "PRIMARY KEY" + " (" + PERFIL_MODULOEntry.COLUMN_codigo_perfil + COMMA_SEP + PERFIL_MODULOEntry.COLUMN_codigo_modulo + " )" +
                    " )";

    // *** SEGMENTO TABLE *** //

    public static class SegmentoEntry implements BaseColumns {
        public static final String TABLE_NAME = "segmento";
        public static final String COLUMN_NAME_CodSegmento= "codigo";
        public static final String COLUMN_NAME_NOMESegmento = "nome";

    }
    public static final String CREATE_SEGMENTO =
            "CREATE TABLE " +" IF NOT EXISTS " + SegmentoEntry.TABLE_NAME + " (" +
                    SegmentoEntry.COLUMN_NAME_CodSegmento + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    SegmentoEntry.COLUMN_NAME_NOMESegmento + TEXT_TYPE +
                    ") ";


    // *** GRUPO TABLE *** //

    public static class GrupoEntry implements BaseColumns {
        public static final String TABLE_NAME = "grupo";
        public static final String COLUMN_NAME_CodGrupo = "codigo";
        public static final String COLUMN_NAME_NOMEGRUPO = "nome";
        public static final String COLUMN_NAME_IDSEGMENTO = "id_segmento";

    }

    public static final String CREATE_GRUPO =
            "CREATE TABLE " +" IF NOT EXISTS " + GrupoEntry.TABLE_NAME + " (" +
                    GrupoEntry.COLUMN_NAME_CodGrupo + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    GrupoEntry.COLUMN_NAME_NOMEGRUPO + TEXT_TYPE  +COMMA_SEP +
                    GrupoEntry.COLUMN_NAME_IDSEGMENTO + INTEGER_TYPE  +COMMA_SEP +

                    "FOREIGN KEY"+ " (" + GrupoEntry.COLUMN_NAME_IDSEGMENTO +") "+ "REFERENCES " + SegmentoEntry.TABLE_NAME
                    +" ("+ SegmentoEntry.COLUMN_NAME_CodSegmento +") "  +
                    ") ";


    // *** ESTADO TABLE *** //

    public static class EstadoEntry implements BaseColumns {
        public static final String TABLE_NAME = "estado";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_nome= "nome";
    }

    public static final String CREATE_ESTADO =
            "CREATE TABLE "  +" IF NOT EXISTS " + EstadoEntry.TABLE_NAME + " (" +
                    EstadoEntry.COLUMN_NAME_codigo + TEXT_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    EstadoEntry.COLUMN_NAME_nome + TEXT_TYPE +
                    " )";

    // *** CIDADE TABLE *** //

    public static class CidadeEntry implements BaseColumns {
        public static final String TABLE_NAME = "cidade";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_nome = "nome";
        public static final String COLUMN_NAME_cod_estado = "cod_estado";
    }

    public static final String CREATE_CIDADE =
            "CREATE TABLE "  +" IF NOT EXISTS " + CidadeEntry.TABLE_NAME + " (" +
                    CidadeEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    CidadeEntry.COLUMN_NAME_nome + TEXT_TYPE + COMMA_SEP +
                    CidadeEntry.COLUMN_NAME_cod_estado + TEXT_TYPE +

                    //"FOREIGN KEY"+ " (" +  CidadeEntry.COLUMN_NAME_cod_estado + ") " + "REFERENCES " + EstadoEntry.TABLE_NAME + "( " + EstadoEntry.COLUMN_NAME_codigo + " )" +
                    " )" ;

    // *** BARRIO TABLE *** //
    public static class BarrioEntry implements BaseColumns{
        public static final String TABLE_NAME = "barrio";
        public static final String COLUMN_NAME_codigo ="codigo";
        public static final String COLUMN_NAME_nome ="nome";
        public static final String COLUMN_NAME_id_cidade ="id_cidade";
    }

    public static final String CREATE_BARRIO =
            "CREATE TABLE "+ " IF NOT EXISTS "+ BarrioEntry.TABLE_NAME +" ("+
                    BarrioEntry.COLUMN_NAME_codigo + INTEGER_TYPE +"PRIMARY KEY"+ COMMA_SEP +
                    BarrioEntry.COLUMN_NAME_nome + TEXT_TYPE +COMMA_SEP+
                    BarrioEntry.COLUMN_NAME_id_cidade+INTEGER_TYPE+ COMMA_SEP+

                    "FOREIGN KEY"+ " (" +  BarrioEntry.COLUMN_NAME_id_cidade + ") " + "REFERENCES " + CidadeEntry.TABLE_NAME + "( " + CidadeEntry.COLUMN_NAME_codigo + " )" +
                    " )" ;

    // *** DEVICE TABLE *** //

    public static class DeviceEntry implements BaseColumns {
        public static final String TABLE_NAME = "device";
        public static final String COLUMN_NAME_PIM = "pim";
        public static final String COLUMN_NAME_IMEI = "imei";
        public static final String COLUMN_NAME_VERSION = "version";
        public static final String COLUMN_NAME_URL_RASTREIO = "url_rastreio";
        public static final String COLUMN_NAME_URL_INFRACAO = "url_infracao";
        public static final String COLUMN_NAME_URL_TABELAS = "url_tabelas";
        public static final String COLUMN_NAME_URL_CONSULTAS = "url_consultas";
    }

    public static final String CREATE_DEVICE =
            "CREATE TABLE "  +" IF NOT EXISTS " + DeviceEntry.TABLE_NAME + " (" +
                    DeviceEntry.COLUMN_NAME_PIM + TEXT_TYPE + COMMA_SEP +
                    DeviceEntry.COLUMN_NAME_IMEI + TEXT_TYPE + COMMA_SEP +
                    DeviceEntry.COLUMN_NAME_VERSION + TEXT_TYPE + COMMA_SEP +
                    DeviceEntry.COLUMN_NAME_URL_RASTREIO + TEXT_TYPE + COMMA_SEP +
                    DeviceEntry.COLUMN_NAME_URL_INFRACAO + TEXT_TYPE + COMMA_SEP +
                    DeviceEntry.COLUMN_NAME_URL_TABELAS + TEXT_TYPE + COMMA_SEP +
                    DeviceEntry.COLUMN_NAME_URL_CONSULTAS + TEXT_TYPE + COMMA_SEP +
                    "PRIMARY KEY" + " (" + DeviceEntry.COLUMN_NAME_PIM + COMMA_SEP + DeviceEntry.COLUMN_NAME_IMEI + " )" +

                    " )";

    // *** USUARIO TABLE *** //

    public static class UsuarioEntry implements BaseColumns {
        public static final String TABLE_NAME = "usuario";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_nome = "nome";
        public static final String COLUMN_NAME_login = "login";
        public static final String COLUMN_NAME_senha = "senha";
        public static final String COLUMN_NAME_cpf = "cpf";
        public static final String COLUMN_NAME_endereco = "endereco";
        public static final String COLUMN_NAME_complemento = "complemento";
        public static final String COLUMN_NAME_cep = "cep";
        public static final String COLUMN_NAME_foto = "foto";
        public static final String COLUMN_NAME_matricula = "matricula";
        public static final String COLUMN_NAME_numero_idendidade = "numero_idendidade";
        public static final String COLUMN_NAME_id_orgao = "id_orgao";
        public static final String COLUMN_NAME_nome_orgao = "nome_orgao";
        public static final String COLUMN_NAME_id_grupo = "id_grupo";
        public static final String COLUMN_NAME_segmento = "segmento";
        public static final String COLUMN_NAME_id_perfil = "id_perfil";
        public static final String COLUMN_NAME_perfil = "perfil";
        public static final String COLUMN_NAME_uf = "uf";
        public static final String COLUMN_NAME_id_cidade = "id_cidade";
        public static final String COLUMN_NAME_nome_cidade = "nome_cidade";
        public static final String COLUMN_NAME_data_atualizacao = "data_atualizacao";
        public static final String COLUMN_NAME_modulos = "modulos";

    }
    public static final String CREATE_USUARIO =
            "CREATE TABLE "  +" IF NOT EXISTS " + UsuarioEntry.TABLE_NAME + " ( " +
                    UsuarioEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_nome + TEXT_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_login + TEXT_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_senha + TEXT_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_cpf + TEXT_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_endereco + TEXT_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_complemento + TEXT_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_cep + TEXT_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_foto + IMAGE_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_matricula + TEXT_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_numero_idendidade + TEXT_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_id_orgao + INTEGER_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_nome_orgao + INTEGER_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_id_grupo + INTEGER_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_segmento + TEXT_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_id_perfil + INTEGER_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_perfil + TEXT_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_uf + TEXT_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_id_cidade + INTEGER_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_nome_cidade + TEXT_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_data_atualizacao + TEXT_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_modulos + TEXT_TYPE + COMMA_SEP +

                    "FOREIGN KEY"+ " ( " + UsuarioEntry.COLUMN_NAME_id_grupo + " ) " + "REFERENCES " + GrupoEntry.TABLE_NAME + " ( " + GrupoEntry.COLUMN_NAME_CodGrupo + " ) " + COMMA_SEP +
                    " FOREIGN KEY"+ " ( " + UsuarioEntry.COLUMN_NAME_id_perfil + " ) " + "REFERENCES " + PerfilEntry.TABLE_NAME + " ( " + PerfilEntry.COLUMN_NAME_CodPerfil + " )" +
                    " )";


    // *** USUARIODEVICE TABLE *** //

    public static class Usuario_deviceEntry implements BaseColumns {
        public static final String TABLE_NAME = "usuario_device";
        public static final String COLUMN_PimUsuarioDevice = "pim";
        public static final String COLUMN_ImeiUsuarioDevice = "imei";
        public static final String COLUMN_codigoUsuarioUsuarioDevice = "codigo_usuario";
        public static final String COLUMN_online = "online";
    }

    public static final String CREATE_USUARIO_DEVICE =
            "CREATE TABLE "  +" IF NOT EXISTS " + Usuario_deviceEntry.TABLE_NAME + " (" +
                    Usuario_deviceEntry.COLUMN_PimUsuarioDevice + TEXT_TYPE + COMMA_SEP +
                    Usuario_deviceEntry.COLUMN_ImeiUsuarioDevice + TEXT_TYPE + COMMA_SEP +
                    Usuario_deviceEntry.COLUMN_codigoUsuarioUsuarioDevice  +INTEGER_TYPE + COMMA_SEP +
                    Usuario_deviceEntry.COLUMN_online  +TEXT_TYPE + COMMA_SEP +

                    "PRIMARY KEY" + " ( " + Usuario_deviceEntry.COLUMN_PimUsuarioDevice + COMMA_SEP + Usuario_deviceEntry.COLUMN_ImeiUsuarioDevice + COMMA_SEP + Usuario_deviceEntry.COLUMN_codigoUsuarioUsuarioDevice + ") "  + COMMA_SEP +
                    "FOREIGN KEY"+ " ( " + Usuario_deviceEntry.COLUMN_PimUsuarioDevice + COMMA_SEP + Usuario_deviceEntry.COLUMN_ImeiUsuarioDevice + ") " + "REFERENCES " + DeviceEntry.TABLE_NAME + "( " + DeviceEntry.COLUMN_NAME_PIM + COMMA_SEP + DeviceEntry.COLUMN_NAME_IMEI + " ) " + COMMA_SEP +
                    "FOREIGN KEY"+ " ( " + Usuario_deviceEntry.COLUMN_codigoUsuarioUsuarioDevice +" ) "+ "REFERENCES " + UsuarioEntry.TABLE_NAME + " (" + UsuarioEntry.COLUMN_NAME_codigo + ") " +
                    " )";


    // ***  CATEGORIA *** //
    public static class CategoriaEntry implements BaseColumns {
        public static final String TABLE_NAME = "categoria";
        public static final String CATEGORIA_IDENDIDADE = "codigo";
        public static final String COLUMN_tipo = "tipo";
        public static final String COLUMN_descricao = "descricao";

    }

    public static final String CREATE_CATEGORIA =
            "CREATE TABLE "  +" IF NOT EXISTS " + CategoriaEntry.TABLE_NAME + " (" +
                    CategoriaEntry.CATEGORIA_IDENDIDADE + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    CategoriaEntry.COLUMN_tipo + TEXT_TYPE +COMMA_SEP +
                    CategoriaEntry.COLUMN_descricao + TEXT_TYPE +
                    " )";



    // *** CONDUTOR TABLE *** //
    public static class CondutorEntry implements BaseColumns {
        public static final String TABLE_NAME = "condutor";
        public static final String COLUMN_NAME_codigoconductor= "codigo";
        public static final String COLUMN_NAME_NOMEconductor = "nome";
        public static final String COLUMN_NAME_maeUsuarioconductor = "mae";
        public static final String COLUMN_NAME_sexoconductor= "sexo";
        public static final String COLUMN_NAME_telefoneconductor = "telefone";
        public static final String COLUMN_NAME_nasciamentoconductor = "nascimento";
        public static final String COLUMN_NAME_enderecoconductor= "endereco";
        public static final String COLUMN_NAME_complementoconductor = "complemento";
        public static final String COLUMN_NAME_cepconductor = "cep";
        public static final String COLUMN_NAME_cnhconductor= "cnh";
        public static final String COLUMN_NAME_cpfconductor= "cpf";
        public static final String COLUMN_NAME_validade_cnhconductor = "validade_cnh";
        public static final String COLUMN_NAME_id_categoriaconductor = "id_categoria";
        public static final String COLUMN_NAME_cidade_nasc = "cidade_nasc";
        public static final String COLUMN_NAME_cidade_cpf = "cidade_cpf";
    }
    public static final String CREATE_CONDUTOR =
            "CREATE TABLE "  +" IF NOT EXISTS " + CondutorEntry.TABLE_NAME + " (" +
                    CondutorEntry.COLUMN_NAME_codigoconductor + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    CondutorEntry.COLUMN_NAME_NOMEconductor + TEXT_TYPE + COMMA_SEP +
                    CondutorEntry.COLUMN_NAME_maeUsuarioconductor + TEXT_TYPE + COMMA_SEP +
                    CondutorEntry.COLUMN_NAME_sexoconductor + TEXT_TYPE + COMMA_SEP +
                    CondutorEntry.COLUMN_NAME_telefoneconductor + TEXT_TYPE + COMMA_SEP +
                    CondutorEntry.COLUMN_NAME_nasciamentoconductor + DATE_TYPE + COMMA_SEP +
                    CondutorEntry.COLUMN_NAME_enderecoconductor + TEXT_TYPE + COMMA_SEP +
                    CondutorEntry.COLUMN_NAME_complementoconductor + TEXT_TYPE + COMMA_SEP +
                    CondutorEntry.COLUMN_NAME_cepconductor + TEXT_TYPE + COMMA_SEP +
                    CondutorEntry.COLUMN_NAME_cnhconductor + TEXT_TYPE + COMMA_SEP +
                    CondutorEntry.COLUMN_NAME_cpfconductor + TEXT_TYPE + COMMA_SEP +
                    CondutorEntry.COLUMN_NAME_validade_cnhconductor + TEXT_TYPE + COMMA_SEP +
                    CondutorEntry.COLUMN_NAME_id_categoriaconductor + TEXT_TYPE + COMMA_SEP +
                    CondutorEntry.COLUMN_NAME_cidade_nasc + TEXT_TYPE + COMMA_SEP +
                    CondutorEntry.COLUMN_NAME_cidade_cpf + TEXT_TYPE + COMMA_SEP +

                    "FOREIGN KEY" + " (" + CondutorEntry.COLUMN_NAME_cidade_nasc + ")" + " REFERENCES " + CidadeEntry.TABLE_NAME + " (" + CidadeEntry.COLUMN_NAME_codigo + ")" + COMMA_SEP +
                    "FOREIGN KEY" + " (" + CondutorEntry.COLUMN_NAME_cidade_cpf + ")" + " REFERENCES " + CidadeEntry.TABLE_NAME + " (" + CidadeEntry.COLUMN_NAME_codigo + ")" + COMMA_SEP +
                    "FOREIGN KEY"+ " (" + CondutorEntry.COLUMN_NAME_id_categoriaconductor + ") " + "REFERENCES " + CategoriaEntry.TABLE_NAME + " ( " + CategoriaEntry.CATEGORIA_IDENDIDADE + " ))";



    // *** table VEICULO *** //
    public static class VEICULOEntry implements BaseColumns {
        public static final String TABLE_NAME = "veiculo";
        public static final String COLUMN_NAME_placa= "placa";
        public static final String COLUMN_NAME_renavam = "renavam";
        public static final String COLUMN_NAME_tipo = "tipo";
        public static final String COLUMN_especie= "especie";
        public static final String COLUMN_NAME_marca = "marca";
        public static final String COLUMN_NAME_chassi = "chassi";
        public static final String COLUMN_NAME_anofabricacao= "anofabricacao";
        public static final String COLUMN_NAME_anomodelo = "anomodelo";
        public static final String COLUMN_NAME_combustivel = "combustivel";
        public static final String COLUMN_NAME_cor= "cor";
        public static final String COLUMN_NAME_data_insercao = "data_insercao";

    }

    public static final String CREATE_VEICULO =
            "CREATE TABLE "  +" IF NOT EXISTS " + VEICULOEntry.TABLE_NAME + " (" +
                    VEICULOEntry.COLUMN_NAME_placa + TEXT_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    VEICULOEntry.COLUMN_NAME_renavam + TEXT_TYPE + COMMA_SEP +
                    VEICULOEntry.COLUMN_NAME_tipo + TEXT_TYPE + COMMA_SEP +
                    VEICULOEntry.COLUMN_especie + TEXT_TYPE + COMMA_SEP +
                    VEICULOEntry.COLUMN_NAME_marca + DATE_TYPE + COMMA_SEP +
                    VEICULOEntry.COLUMN_NAME_chassi + TEXT_TYPE + COMMA_SEP +
                    VEICULOEntry.COLUMN_NAME_anofabricacao + TEXT_TYPE + COMMA_SEP +
                    VEICULOEntry.COLUMN_NAME_anomodelo + TEXT_TYPE + COMMA_SEP +
                    VEICULOEntry.COLUMN_NAME_combustivel + TEXT_TYPE + COMMA_SEP +
                    VEICULOEntry.COLUMN_NAME_cor + TEXT_TYPE + COMMA_SEP +
                    VEICULOEntry.COLUMN_NAME_data_insercao + TEXT_TYPE +
                    " )";


    // *** CONDUCTOR_VEICULO TABLE *** //
    public static class Condutor_VeiculoEntry implements BaseColumns {
        public static final String TABLE_NAME = "conductor_veiculo";
        public static final String COLUMN_id_conductor = "id_conductor";
        public static final String COLUMN_id_veiculo = "id_veiculo";
        public static final String COLUMN_data_insercao = "data_insercao";

    }

    public static final String CREATE_CONDUCTOR_VEICULO =
            "CREATE TABLE "  +" IF NOT EXISTS " + Condutor_VeiculoEntry.TABLE_NAME + " (" +
                    Condutor_VeiculoEntry.COLUMN_id_conductor + INTEGER_TYPE + COMMA_SEP +
                    Condutor_VeiculoEntry.COLUMN_id_veiculo + TEXT_TYPE + COMMA_SEP +
                    Condutor_VeiculoEntry.COLUMN_data_insercao  +DATE_TYPE + COMMA_SEP +


                    "PRIMARY KEY" + " ( " + Condutor_VeiculoEntry.COLUMN_id_conductor + COMMA_SEP + Condutor_VeiculoEntry.COLUMN_id_veiculo+ ") "  + COMMA_SEP +
                    "FOREIGN KEY"+ " (" + Condutor_VeiculoEntry.COLUMN_id_conductor +") "+ "REFERENCES " + CondutorEntry.TABLE_NAME + " ( " + CondutorEntry.COLUMN_NAME_codigoconductor + " )" +
                    "FOREIGN KEY"+ " (" + Condutor_VeiculoEntry.COLUMN_id_veiculo +") "+ "REFERENCES " + VEICULOEntry.TABLE_NAME + " ( " + VEICULOEntry.COLUMN_NAME_placa + " )" +
                    " )";

    // *** CIDADE ACCESS *** //

    public static class ACCESSEntry implements BaseColumns {
        public static final String TABLE_NAME = "acceso";
        public static final String COLUMN_data_codigoAccess = "codigo";
        public static final String COLUMN_data_onAccess = "data_online";
        public static final String COLUMN_data_offAccess = "data_offline";
        public static final String COLUMN_NAME_longitude = "longitude";
        public static final String COLUMN_NAME_latitude = "latitude";
        public static final String COLUMN_NAME_bloq_device = "bloq_device";
        public static final String COLUMN_NAME_bloq_usuario = "bloq_usuario";
        public static final String COLUMN_pim = "pim";
        public static final String COLUMN_Imei = "imei";
        public static final String COLUMN_codigoUsuario = "codigo_usuario";
    }

    public static final String CREATE_ACCESO =
            "CREATE TABLE "  +" IF NOT EXISTS " + ACCESSEntry.TABLE_NAME + " (" +
                    ACCESSEntry.COLUMN_data_codigoAccess + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    ACCESSEntry.COLUMN_data_onAccess + DATE_TYPE + COMMA_SEP +
                    ACCESSEntry.COLUMN_data_offAccess + DATE_TYPE +COMMA_SEP +
                    ACCESSEntry.COLUMN_NAME_longitude + TEXT_TYPE +COMMA_SEP +
                    ACCESSEntry.COLUMN_NAME_latitude + TEXT_TYPE +COMMA_SEP +
                    ACCESSEntry.COLUMN_NAME_bloq_device + TEXT_TYPE +COMMA_SEP +
                    ACCESSEntry.COLUMN_NAME_bloq_usuario + TEXT_TYPE +COMMA_SEP +
                    ACCESSEntry.COLUMN_pim + TEXT_TYPE + COMMA_SEP +
                    ACCESSEntry.COLUMN_Imei + TEXT_TYPE + COMMA_SEP +
                    ACCESSEntry.COLUMN_codigoUsuario + INTEGER_TYPE + COMMA_SEP +
                    "FOREIGN KEY"+ " (" + ACCESSEntry.COLUMN_pim + COMMA_SEP + ACCESSEntry.COLUMN_Imei + ") " + "REFERENCES " + DeviceEntry.TABLE_NAME + " ( " + DeviceEntry.COLUMN_NAME_PIM + COMMA_SEP + DeviceEntry.COLUMN_NAME_IMEI + ") " + COMMA_SEP +
                    "FOREIGN KEY"+ " (" + ACCESSEntry.COLUMN_codigoUsuario +") "+ "REFERENCES " + UsuarioEntry.TABLE_NAME + "( " + UsuarioEntry.COLUMN_NAME_codigo + " )" +
                    " )";
    // *** LEI TABLE *** //

    public static class Medida_AdministrativaEntry implements BaseColumns{
        public static final String TABLE_NAME ="Medida_Administrativa";
        public static final String COLUMN_codigo ="codigo";
        public static final String COLUMN_artigo ="artigo";
        public static final String COLUMN_inciso ="inciso";
        public static final String COLUMN_descricao ="descricao";
    }
    public static final String CREATE_MEDIDA_ADMINISTRATIVA =
            "CREATE TABLE " + "IF NOT EXISTS " + Medida_AdministrativaEntry.TABLE_NAME + " ("+
                    Medida_AdministrativaEntry.COLUMN_codigo + INTEGER_TYPE + " PRIMARY KEY "+COMMA_SEP +
                    Medida_AdministrativaEntry.COLUMN_artigo + TEXT_TYPE + COMMA_SEP +
                    Medida_AdministrativaEntry.COLUMN_inciso + TEXT_TYPE + COMMA_SEP +
                    Medida_AdministrativaEntry.COLUMN_descricao +TEXT_TYPE + ") ";

    // *** LEI TABLE *** //
    public static class LeiEntry implements BaseColumns {
        public static final String TABLE_NAME = "lei";
/*
        public static final HashMap<String, String> COLUMNS = new HashMap<String, String>(){
            {
                put("codigo", INTEGER_TYPE);
                put("digito", INTEGER_TYPE);
                put("tipo", TEXT_TYPE);
                put("categoria", TEXT_TYPE);
                put("descricao_breve", TEXT_TYPE);
                put("observacao", TEXT_TYPE);
                put("valor", TEXT_TYPE);
                put("moeda", TEXT_TYPE);
                put("fator", TEXT_TYPE);
                put("tipo_infracao", TEXT_TYPE);
                put("descricao", TEXT_TYPE);
                put("infrator", TEXT_TYPE);
                put("amparo", TEXT_TYPE);
                put("tipo_veiculo", TEXT_TYPE);
                put("afericao", TEXT_TYPE);
                put("valor_infracao", TEXT_TYPE);
                put("inativo", TEXT_TYPE);
                put("mbft", TEXT_TYPE);
            }
        };
*/
        public static final String COLUMN_codigo = "codigo";
        public static final String COLUMN_digito = "digito";
        public static final String COLUMN_tipo = "tipo";
        public static final String COLUMN_categoria = "categoria";
        public static final String COLUMN_descricao_breve = "descricao_breve";
        public static final String COLUMN_observacao = "observacao";
        public static final String COLUMN_valor = "valor";
        public static final String COLUMN_moeda = "moeda";
        public static final String COLUMN_fator = "fator";
        public static final String COLUMN_tipo_infracao = "tipo_infracao";
        public static final String COLUMN_descricao = "descricao";
        public static final String COLUMN_infrator = "infrator";
        public static final String COLUMN_amparo = "amparo";
        public static final String COLUMN_tipo_veiculo = "tipo_veiculo";
        public static final String COLUMN_afericao = "afericao";
        public static final String COLUMN_valor_infracao = "valor_infracao";
        public static final String COLUMN_inativo = "inativo";
        public static final String COLUMN_mbft = "mbft";
    }

    public static final String CREATE_LEI =
            "CREATE TABLE IF NOT EXISTS " + LeiEntry.TABLE_NAME + " (" +
                    LeiEntry.COLUMN_codigo + INTEGER_TYPE + " NOT NULL" + COMMA_SEP +
                    LeiEntry.COLUMN_digito + INTEGER_TYPE + " NOT NULL" + COMMA_SEP +
                    LeiEntry.COLUMN_tipo + TEXT_TYPE + COMMA_SEP +
                    LeiEntry.COLUMN_categoria + TEXT_TYPE + COMMA_SEP +
                    LeiEntry.COLUMN_descricao_breve + TEXT_TYPE + " COLLATE NOCASE" + COMMA_SEP +
                    LeiEntry.COLUMN_observacao + TEXT_TYPE + COMMA_SEP +
                    LeiEntry.COLUMN_valor + TEXT_TYPE + COMMA_SEP +
                    LeiEntry.COLUMN_moeda + TEXT_TYPE + COMMA_SEP +
                    LeiEntry.COLUMN_fator + TEXT_TYPE + COMMA_SEP +
                    LeiEntry.COLUMN_tipo_infracao + TEXT_TYPE + COMMA_SEP +
                    LeiEntry.COLUMN_descricao + TEXT_TYPE + " COLLATE NOCASE" + COMMA_SEP +
                    LeiEntry.COLUMN_infrator + TEXT_TYPE + COMMA_SEP +
                    LeiEntry.COLUMN_amparo + TEXT_TYPE + COMMA_SEP +
                    LeiEntry.COLUMN_tipo_veiculo + TEXT_TYPE + COMMA_SEP +
                    LeiEntry.COLUMN_afericao + TEXT_TYPE + COMMA_SEP +
                    LeiEntry.COLUMN_valor_infracao + TEXT_TYPE + COMMA_SEP +
                    LeiEntry.COLUMN_inativo + TEXT_TYPE + COMMA_SEP +
                    LeiEntry.COLUMN_mbft + TEXT_TYPE + COMMA_SEP +
                    "PRIMARY KEY (" + LeiEntry.COLUMN_codigo + COMMA_SEP + LeiEntry.COLUMN_digito + ")" +
                    ") ";

    // *** table INFRACAO *** //
    // *** table INFRACAO *** //
    public static class InfracaoEntry implements BaseColumns {
        public static final String TABLE_NAME = "infracao";
        public static final String COLUMN_NAME_codigo_infracao = "codigo";
        public static final String COLUMN_NAME_auto = "auto";
        public static final String COLUMN_NAME_data_ocorrencia= "data_ocorrencia";
        public static final String COLUMN_NAME_local_ocorrencia= "local_ocorrencia";
        public static final String COLUMN_NAME_tipo_local="tipo_local";
        public static final String COLUMN_NAME_latitude = "latitude";
        public static final String COLUMN_NAME_longitude= "longitude";
        public static final String COLUMN_NAME_descricao = "descricao";
        public static final String COLUMN_NAME_situacao = "situacao";
        public static final String COLUMN_NAME_cancelada = "cancelada";
        public static final String COLUMN_NAME_motivo_cancelada = "motivo_cancelada";
        public static final String COLUMN_NAME_infrator = "infrator";
        public static final String COLUMN_NAME_data_insercao = "data_insercao";
        public static final String COLUMN_NAME_desdobramento = "desdobramento";
        public static final String COLUMN_NAME_recolhercnh = "recolhercnh";
        public static final String COLUMN_NAME_aprenderveiculo = "aprenderveiculo";
        public static final String COLUMN_NAME_recolhercla = "recolhercla";
        public static final String COLUMN_NAME_Pontodereferencia = "Pontodereferencia";


        public static final String COLUMN_NAME_codigo_tipo_infracao = "codigo_tipo_infracao";
        public static final String COLUMN_NAME_id_lei = "id_lei";
        public static final String COLUMN_NAME_id_barrio = "id_barrio";
        public static final String COLUMN_NAME_id_condutor= "id_condutor";
        public static final String COLUMN_NAME_id_veiculo = "id_veiculo";
        public static final String COLUMN_NAME_medida_administrativa = "medida_administrativa";
        public static final String COLUMN_NAME_equipo_usuario_device = "equipo_usuario_device";
        public static final String COLUMN_NAME_digito_lei = "digito_lei";

    }

    public static final String CREATE_INFRACAO =
            "CREATE TABLE "  + " IF NOT EXISTS " + InfracaoEntry.TABLE_NAME + " (" +
                    InfracaoEntry.COLUMN_NAME_codigo_infracao + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_auto + TEXT_TYPE + COMMA_SEP+
                    InfracaoEntry.COLUMN_NAME_data_ocorrencia +TEXT_TYPE +COMMA_SEP+
                    InfracaoEntry.COLUMN_NAME_local_ocorrencia + TEXT_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_tipo_local +TEXT_TYPE +COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_latitude + TEXT_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_longitude + TEXT_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_descricao + TEXT_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_situacao + TEXT_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_cancelada + TEXT_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_motivo_cancelada + TEXT_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_infrator + TEXT_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_data_insercao + TEXT_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_desdobramento + TEXT_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_recolhercnh+TEXT_TYPE+COMMA_SEP+
                    InfracaoEntry.COLUMN_NAME_aprenderveiculo+TEXT_TYPE+COMMA_SEP+
                    InfracaoEntry.COLUMN_NAME_recolhercla+TEXT_TYPE+COMMA_SEP+
                    InfracaoEntry.COLUMN_NAME_Pontodereferencia + INTEGER_TYPE + COMMA_SEP +

                    InfracaoEntry.COLUMN_NAME_codigo_tipo_infracao + INTEGER_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_id_lei + INTEGER_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_id_barrio + TEXT_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_id_condutor + INTEGER_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_id_veiculo + TEXT_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_equipo_usuario_device + INTEGER_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_medida_administrativa + INTEGER_TYPE + COMMA_SEP +
                    InfracaoEntry.COLUMN_NAME_digito_lei+TEXT_TYPE+COMMA_SEP+


                    " FOREIGN KEY"+ " (" +  InfracaoEntry.COLUMN_NAME_id_barrio + " )" + " REFERENCES " + BarrioEntry.TABLE_NAME + "( " + BarrioEntry.COLUMN_NAME_codigo + " ) " +
                    COMMA_SEP + " FOREIGN KEY"+ " (" +  InfracaoEntry.COLUMN_NAME_medida_administrativa + ")" + " REFERENCES " + Medida_AdministrativaEntry.TABLE_NAME + "(" + Medida_AdministrativaEntry.COLUMN_codigo + ")" +
                    COMMA_SEP + " FOREIGN KEY"+ " (" +  InfracaoEntry.COLUMN_NAME_equipo_usuario_device + ")" + " REFERENCES " + EquipoUsuarioDeviceEntry.TABLE_NAME + "(" + EquipoUsuarioDeviceEntry.COLUMN_NAME_codigo + ")" +
                    COMMA_SEP + " FOREIGN KEY"+ " (" +  InfracaoEntry.COLUMN_NAME_codigo_tipo_infracao  + ")" + " REFERENCES " + TipoInfracaoEntry.TABLE_NAME + "(" + TipoInfracaoEntry.COLUMN_NAME_codigo + ")" +
                    COMMA_SEP + " FOREIGN KEY"+ " (" +  InfracaoEntry.COLUMN_NAME_id_lei + COMMA_SEP + InfracaoEntry.COLUMN_NAME_digito_lei + ")" + " REFERENCES " + LeiEntry.TABLE_NAME + "(" + LeiEntry.COLUMN_codigo + COMMA_SEP + LeiEntry.COLUMN_digito + ")" +
                    COMMA_SEP + " FOREIGN KEY"+ " (" +  InfracaoEntry.COLUMN_NAME_id_condutor + COMMA_SEP + InfracaoEntry.COLUMN_NAME_id_veiculo + " ) " + " REFERENCES " + Condutor_VeiculoEntry.TABLE_NAME + " ( " + Condutor_VeiculoEntry.COLUMN_id_conductor + COMMA_SEP + Condutor_VeiculoEntry.COLUMN_id_veiculo + " ) " +
                    " ) ";



    // *** Tipo infracao TABLE *** //

    public static class TipoInfracaoEntry implements BaseColumns {
        public static final String TABLE_NAME = "tipoinfracao";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_nome="nome";

    }

    public static final String CREATE_TipoInfracao =  "CREATE TABLE "  +" IF NOT EXISTS " + TipoInfracaoEntry.TABLE_NAME + " (" +
            TipoInfracaoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY"+ COMMA_SEP +
            TipoInfracaoEntry.COLUMN_NAME_nome + TEXT_TYPE +
            " )";


    // *** Equipo Usuario Device TABLE *** //

    public static class EquipoUsuarioDeviceEntry implements BaseColumns {
        public static final String TABLE_NAME = "equipousuariodevice";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_medicao_realizada="medicao_realizada";
        public static final String COLUMN_NAME_medicao_considerada="medicao_considerada";
        public static final String COLUMN_NAME_limite_establecido="limite_establecido";

        public static final String COLUMN_NAME_numero_equipo = "numero_equipo";
        public static final String COLUMN_NAME_codigousuario="codigousuario";
        public static final String COLUMN_NAME_Pim = "pim";
        public static final String COLUMN_NAME_Imei = "imei";

    }

    public static final String CREATE_EquipoUsuarioDevice =  "CREATE TABLE "  +" IF NOT EXISTS " + EquipoUsuarioDeviceEntry.TABLE_NAME + " (" +
            EquipoUsuarioDeviceEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY"+ COMMA_SEP +
            EquipoUsuarioDeviceEntry.COLUMN_NAME_medicao_realizada + TEXT_TYPE + COMMA_SEP +
            EquipoUsuarioDeviceEntry.COLUMN_NAME_medicao_considerada + TEXT_TYPE + COMMA_SEP +
            EquipoUsuarioDeviceEntry.COLUMN_NAME_limite_establecido + TEXT_TYPE + COMMA_SEP +

            EquipoUsuarioDeviceEntry.COLUMN_NAME_numero_equipo + TEXT_TYPE + COMMA_SEP +
            EquipoUsuarioDeviceEntry.COLUMN_NAME_codigousuario + TEXT_TYPE + COMMA_SEP +
            EquipoUsuarioDeviceEntry.COLUMN_NAME_Pim + TEXT_TYPE + COMMA_SEP +
            EquipoUsuarioDeviceEntry.COLUMN_NAME_Imei + TEXT_TYPE + COMMA_SEP +

            " FOREIGN KEY " + "( " +  EquipoUsuarioDeviceEntry.COLUMN_NAME_numero_equipo + " )" + " REFERENCES " + EquipamentoEntry.TABLE_NAME + " (" + EquipamentoEntry.COLUMN_NAME_numero + ") " + COMMA_SEP +
            " FOREIGN KEY " + "( " +  EquipoUsuarioDeviceEntry.COLUMN_NAME_codigousuario + " )" + " REFERENCES " + Usuario_deviceEntry.TABLE_NAME + " (" + Usuario_deviceEntry.COLUMN_codigoUsuarioUsuarioDevice + ") " + COMMA_SEP +
            " FOREIGN KEY " + "( " +  EquipoUsuarioDeviceEntry.COLUMN_NAME_Pim + " )" + " REFERENCES " + Usuario_deviceEntry.TABLE_NAME + " (" + Usuario_deviceEntry.COLUMN_PimUsuarioDevice + ") " + COMMA_SEP +
            " FOREIGN KEY " + "( " +  EquipoUsuarioDeviceEntry.COLUMN_NAME_Imei + " )" + " REFERENCES " + Usuario_deviceEntry.TABLE_NAME + " (" + Usuario_deviceEntry.COLUMN_ImeiUsuarioDevice + ")" +
            " )";


    // *** Equipamento TABLE *** //

    public static class EquipamentoEntry implements BaseColumns {
        public static final String TABLE_NAME = "equipamento";
        public static final String COLUMN_NAME_numero = "numero";
        public static final String COLUMN_NAME_modelo="modelo";
        public static final String COLUMN_NAME_marca="marca";

    }

    public static final String CREATE_Equipamento =
            "CREATE TABLE "  +" IF NOT EXISTS " + EquipamentoEntry.TABLE_NAME + " (" +
                    EquipamentoEntry.COLUMN_NAME_numero + INTEGER_TYPE + " PRIMARY KEY"+ COMMA_SEP +
                    EquipamentoEntry.COLUMN_NAME_modelo + TEXT_TYPE + COMMA_SEP +
                    EquipamentoEntry.COLUMN_NAME_marca + TEXT_TYPE +
                    " )";


    // *** Messegens TABLE *** //

    public static class MessegensEntry implements BaseColumns {
        public static final String TABLE_NAME = "messegens";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_segmento="segmento";
        public static final String COLUMN_NAME_grupo="grupo";
        public static final String COLUMN_NAME_usuario="usuario";
        public static final String COLUMN_NAME_asunto="asunto";
        public static final String COLUMN_NAME_contudo="contudo";
        public static final String COLUMN_NAME_data="data";
        public static final String COLUMN_NAME_cadastrante="cadastrante";
    }

    public static final String CREATE_Messegens =
            "CREATE TABLE "  +" IF NOT EXISTS " + MessegensEntry.TABLE_NAME + " (" +
                    MessegensEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY"+ COMMA_SEP +
                    MessegensEntry.COLUMN_NAME_segmento + TEXT_TYPE + COMMA_SEP +
                    MessegensEntry.COLUMN_NAME_grupo + INTEGER_TYPE + COMMA_SEP +
                    MessegensEntry.COLUMN_NAME_usuario + INTEGER_TYPE + COMMA_SEP +
                    MessegensEntry.COLUMN_NAME_asunto + TEXT_TYPE + COMMA_SEP +
                    MessegensEntry.COLUMN_NAME_contudo + TEXT_TYPE + COMMA_SEP +
                    MessegensEntry.COLUMN_NAME_data + TEXT_TYPE + COMMA_SEP +
                    MessegensEntry.COLUMN_NAME_cadastrante + INTEGER_TYPE +
                    " )";

    // *** FOTO_BOAT TABLE *** //

    public static class Foto_BoatEntry implements BaseColumns {
        public static final String TABLE_NAME = "foto_boat";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_foto = "foto";
        public static final String COLUMN_NAME_name = "nome";
        public static final String COLUMN_NAME_id_boat = "id_boat";
    }

    public static final String CREATE_FOTO_BOAT =
            "CREATE TABLE " + " IF NOT EXISTS " + Foto_BoatEntry.TABLE_NAME + " (" +
                    Foto_BoatEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    Foto_BoatEntry.COLUMN_NAME_foto + TEXT_TYPE + COMMA_SEP +
                    Foto_BoatEntry.COLUMN_NAME_name + TEXT_TYPE + COMMA_SEP +
                    Foto_BoatEntry.COLUMN_NAME_id_boat + TEXT_TYPE +
//                    " FOREIGN KEY" + " (" +  Foto_BoatEntry.COLUMN_NAME_id_boat + ") " + " REFERENCES " + BoatEntry.TABLE_NAME + " (" + BoatEntry.COLUMN_NAME_codigo + ") " +
                    " )";


    ///*VEICULO_BOAT_CONDUTOR*/

    public static class Veiculo_Boat_Entry implements BaseColumns {
        public static final String TABLE_NAME = "Veiculo_boat_condutor";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_airbag = "airbag";
        public static final String COLUMN_NAME_tipo_carga = "tipo_carga";
        public static final String COLUMN_NAME_peso_carga = "peso_carga";
        public static final String COLUMN_NAME_danos_carga = "danos_carga";
        public static final String COLUMN_NAME_num_aet = "num_aet";
        public static final String COLUMN_NAME_num_ocupante = "ocupante";
        public static final String COLUMN_NAME_cavaleiro = "cavaleiro";
        public static final String COLUMN_NAME_arremessado = "arremessado";
        public static final String COLUMN_NAME_estado = "estado";
        public static final String COLUMN_NAME_reacao = "reacao";
        public static final String COLUMN_NAME_habilitacao = "habilitacao";
        public static final String COLUMN_NAME_tipo_examen = "tipo_examen";
        public static final String COLUMN_NAME_cinto = "cinto";
        public static final String COLUMN_NAME_cpacite = "cpacite";
        public static final String COLUMN_NAME_p_placa = "p_placa";
        public static final String COLUMN_NAME_p_defense = "p_defense";
        public static final String COLUMN_NAME_p_outro = "p_outro";
        public static final String COLUMN_NAME_p_onibus = "p_onibus";
        public static final String COLUMN_NAME_p_iluminacao = "p_iluminacao";
        public static final String COLUMN_NAME_p_portico = "p_portico";
        public static final String COLUMN_NAME_p_nenhum = "p_nenhum";
        public static final String COLUMN_NAME_cpf = "cpf";
        public static final String COLUMN_NAME_placa = "placa";

    }

    public static final String CREATE_VEICULO_BOAT =
            "CREATE TABLE " + " IF NOT EXISTS " + Veiculo_Boat_Entry.TABLE_NAME + " (" +
                    Veiculo_Boat_Entry.COLUMN_NAME_codigo + TEXT_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_airbag + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_tipo_carga + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_peso_carga + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_danos_carga + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_num_aet + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_num_ocupante + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_cavaleiro + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_arremessado + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_estado + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_reacao + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_habilitacao + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_tipo_examen + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_cinto + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_cpacite + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_p_placa + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_p_defense + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_p_outro + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_p_onibus + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_p_iluminacao + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_p_portico + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_p_nenhum + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_cpf + TEXT_TYPE + COMMA_SEP +
                    Veiculo_Boat_Entry.COLUMN_NAME_placa + TEXT_TYPE +
                    ") ";


    // *** VICTIM TABLE *** //
    public static class VitimaEntry implements BaseColumns {
        public static final String TABLE_NAME = "vitima";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_cpf = "cpf";
        public static final String COLUMN_NAME_morador_rua = "morador_rua";
        public static final String COLUMN_NAME_estado = "estado";
        public static final String COLUMN_NAME_tipo_envolvimento = "tipo_envolvimento";
        public static final String COLUMN_NAME_viajava = "viajava";
        public static final String COLUMN_NAME_cinto = "cinto";
        public static final String COLUMN_NAME_capacete_segu = "capacete_segu";
        public static final String COLUMN_NAME_mecanismo_retencao = "mecanismo_retencao";
        public static final String COLUMN_NAME_id_boat ="id_boat";

    }


    public static final String CREATE_VITIMA =
            "CREATE TABLE " + " IF NOT EXISTS " + VitimaEntry.TABLE_NAME + " (" +
                    VitimaEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    VitimaEntry.COLUMN_NAME_cpf + TEXT_TYPE + COMMA_SEP +
                    VitimaEntry.COLUMN_NAME_morador_rua + TEXT_TYPE + COMMA_SEP +
                    VitimaEntry.COLUMN_NAME_estado + TEXT_TYPE + COMMA_SEP +
                    VitimaEntry.COLUMN_NAME_tipo_envolvimento + TEXT_TYPE + COMMA_SEP +
                    VitimaEntry.COLUMN_NAME_viajava + TEXT_TYPE + COMMA_SEP +
                    VitimaEntry.COLUMN_NAME_cinto + TEXT_TYPE + COMMA_SEP +
                    VitimaEntry.COLUMN_NAME_capacete_segu + TEXT_TYPE + COMMA_SEP +
                    VitimaEntry.COLUMN_NAME_mecanismo_retencao + TEXT_TYPE + COMMA_SEP +
                    VitimaEntry.COLUMN_NAME_id_boat+TEXT_TYPE+ COMMA_SEP +

                    " FOREIGN KEY" + " (" +  VitimaEntry.COLUMN_NAME_id_boat + ") " + " REFERENCES " + BoatEntry.TABLE_NAME + " (" + BoatEntry.COLUMN_NAME_codigo + ") " +
                    ") ";

    // *** Testmunha TABLE *** //
    public static class TestemenhaEntry implements BaseColumns {
        public static final String TABLE_NAME = "testemenhas";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_cpf = "cpf";
        public static final String COLUMN_NAME_nome = "nome";
        public static final String COLUMN_NAME_nacinalidade = "nacinalidade";
        public static final String COLUMN_NAME_rg = "rg";
        public static final String COLUMN_NAME_orgaoemissor = "orgaoemissor";
        public static final String COLUMN_NAME_ufrg = "ufrg";
        public static final String COLUMN_NAME_datanacim = "datanacim";
        public static final String COLUMN_NAME_sexo = "sexo";
        public static final String COLUMN_NAME_uf = "uf";
        public static final String COLUMN_NAME_enedereco = "enedereco";
        public static final String COLUMN_NAME_telresidencial = "telresidencial";
        public static final String COLUMN_NAME_telcelular = "telcelular";
        public static final String COLUMN_NAME_teltrabalho = "teltrabalho";
        public static final String COLUMN_NAME_id_boat = "id_boat";

    }


    public static final String CREATE_Testemenha =
            "CREATE TABLE " + " IF NOT EXISTS " + TestemenhaEntry.TABLE_NAME + " (" +
                    TestemenhaEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    TestemenhaEntry.COLUMN_NAME_cpf + TEXT_TYPE + COMMA_SEP +
                    TestemenhaEntry.COLUMN_NAME_nome + TEXT_TYPE + COMMA_SEP +
                    TestemenhaEntry.COLUMN_NAME_nacinalidade + TEXT_TYPE + COMMA_SEP +
                    TestemenhaEntry.COLUMN_NAME_rg + TEXT_TYPE + COMMA_SEP +
                    TestemenhaEntry.COLUMN_NAME_orgaoemissor + TEXT_TYPE + COMMA_SEP +
                    TestemenhaEntry.COLUMN_NAME_ufrg + TEXT_TYPE + COMMA_SEP +
                    TestemenhaEntry.COLUMN_NAME_datanacim + TEXT_TYPE + COMMA_SEP +
                    TestemenhaEntry.COLUMN_NAME_sexo + TEXT_TYPE + COMMA_SEP +
                    TestemenhaEntry.COLUMN_NAME_uf + TEXT_TYPE + COMMA_SEP +
                    TestemenhaEntry.COLUMN_NAME_enedereco + TEXT_TYPE + COMMA_SEP +
                    TestemenhaEntry.COLUMN_NAME_telresidencial + TEXT_TYPE + COMMA_SEP +
                    TestemenhaEntry.COLUMN_NAME_telcelular + TEXT_TYPE + COMMA_SEP +
                    TestemenhaEntry.COLUMN_NAME_teltrabalho + TEXT_TYPE + COMMA_SEP +
                    TestemenhaEntry.COLUMN_NAME_id_boat +TEXT_TYPE+COMMA_SEP+

                    " FOREIGN KEY" + " (" +  TestemenhaEntry.COLUMN_NAME_id_boat + ") " + " REFERENCES " + BoatEntry.TABLE_NAME + " (" + BoatEntry.COLUMN_NAME_codigo + ") " +
                    ") ";

    //*** BOAT TABLE *** //
    public static class BoatEntry implements BaseColumns{
        public static final String TABLE_NAME="boat";
        public static final String COLUMN_NAME_codigo="codigo";
        public static final String COLUMN_NAME_ocorrencia_ciade="ocorrencia_ciade";
        public static final String COLUMN_NAME_ano_oco_ciade="ano_oco_ciade";
        public static final String COLUMN_NAME_codigo_ocorrencia="codigo_ocorrencia";
        public static final String COLUMN_NAME_ocorrencia_dp="ocorrencia_dp";
        public static final String COLUMN_NAME_ano_oco_dp="ano_oco_dp";
        public static final String COLUMN_NAME_numero_dp="numero_dp";
        public static final String COLUMN_NAME_vtr="vtr";
        public static final String COLUMN_NAME_numero_posto="numero_posto";
        public static final String COLUMN_NAME_data_acidente="data_acidente";
        public static final String COLUMN_NAME_data_acionamento_ciade="data_acionamento_ciade";
        public static final String COLUMN_NAME_data_chegada_local="data_chegada_local";
        public static final String COLUMN_NAME_data_encerramento_local="data_encerramento_local";
        public static final String COLUMN_NAME_data_chegada_dp="data_chegada_dp";
        public static final String COLUMN_NAME_data_encerramento_dp="data_encerramento_dp";
        public static final String COLUMN_NAME_rodovia="rodovia";
        public static final String COLUMN_NAME_km="km";
        public static final String COLUMN_NAME_trecho="trecho";
        public static final String COLUMN_NAME_referencia="referencia";
        public static final String COLUMN_NAME_sentido="sentido";
        public static final String COLUMN_NAME_ra="ra";
        public static final String COLUMN_NAME_latitude="latitude";
        public static final String COLUMN_NAME_longitude="longitude";
        public static final String COLUMN_NAME_historico="historico";
        public static final String COLUMN_NAME_situacao="situacao";
    }
    public static final String CREATE_BOAT =
            "CREATE TABLE " + " IF NOT EXISTS "+ BoatEntry.TABLE_NAME + " ("+
                    BoatEntry.COLUMN_NAME_codigo +INTEGER_TYPE +" PRIMARY KEY "+ COMMA_SEP+
                    BoatEntry.COLUMN_NAME_ocorrencia_ciade + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_ano_oco_ciade + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_codigo_ocorrencia + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_ocorrencia_dp + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_ano_oco_dp + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_numero_dp + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_vtr + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_numero_posto + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_data_acidente + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_data_acionamento_ciade + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_data_chegada_local + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_data_encerramento_local + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_data_chegada_dp + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_data_encerramento_dp + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_rodovia + TEXT_TYPE + COMMA_SEP+
                    BoatEntry.COLUMN_NAME_km + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_trecho + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_referencia + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_sentido + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_ra + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_latitude + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_longitude + TEXT_TYPE + COMMA_SEP +
                    BoatEntry.COLUMN_NAME_historico +TEXT_TYPE+COMMA_SEP+
                    BoatEntry.COLUMN_NAME_situacao +TEXT_TYPE+
                    " )";

    // *** COMPLEMENT TABLE *** //
    public static class ComplementEntry implements BaseColumns{
        public static final String TABLE_NAME="complement";
        public static final String COLUMN_NAME_codigo="codigo";
        public static final String COLUMN_NAME_illuminacao="iluminacao";
        public static final String COLUMN_NAME_visibilidade="visibilidade";
        public static final String COLUMN_NAME_tipo_pista="tipo_pista";
        public static final String COLUMN_NAME_tipo_pavimento="tipo_pavimento";
        public static final String COLUMN_NAME_superficie_pista="superficie_pista";
        public static final String COLUMN_NAME_situacao_pista="situacao_pista";
        public static final String COLUMN_NAME_formato_vertical_pista="formato_vertical_pista";
        public static final String COLUMN_NAME_formato_horizontal_pista="formato_horizontal_pista";
        public static final String COLUMN_NAME_separacao_fisica_central="separacao_fisica_central";
        public static final String COLUMN_NAME_numero_faixas="numero_faixas";
        public static final String COLUMN_NAME_velocidade_maxima="velocidade_maxima";
        public static final String COLUMN_NAME_sinalizacao_vertical="senalizacao_vertical";
        public static final String COLUMN_NAME_sinalizacao_horizontal="sinalizacao_horizontal";
        public static final String COLUMN_NAME_condicao_sinalizacao_semaforica="condicao_sinalizacao_semaforica";
        public static final String COLUMN_NAME_local_proximo_acidente="local_proximo_acidente";
        public static final String COLUMN_NAME_controle_trefego="controle_trafego";
        public static final String COLUMN_NAME_trecho_local="trecho_local";
        public static final String COLUMN_NAME_id_boat="id_boat";

    }
    public static final String CREATE_COMPLEMENT =
            "CREATE TABLE " + " IF NOT EXISTS "+ ComplementEntry.TABLE_NAME + " ("+
                    ComplementEntry.COLUMN_NAME_codigo +INTEGER_TYPE +" PRIMARY KEY"+ COMMA_SEP+
                    ComplementEntry.COLUMN_NAME_illuminacao + TEXT_TYPE + COMMA_SEP +
                    ComplementEntry.COLUMN_NAME_visibilidade + TEXT_TYPE + COMMA_SEP +
                    ComplementEntry.COLUMN_NAME_tipo_pista+ TEXT_TYPE + COMMA_SEP +
                    ComplementEntry.COLUMN_NAME_tipo_pavimento + TEXT_TYPE + COMMA_SEP +
                    ComplementEntry.COLUMN_NAME_superficie_pista + TEXT_TYPE + COMMA_SEP +
                    ComplementEntry.COLUMN_NAME_situacao_pista + TEXT_TYPE + COMMA_SEP +
                    ComplementEntry.COLUMN_NAME_formato_vertical_pista + TEXT_TYPE + COMMA_SEP +
                    ComplementEntry.COLUMN_NAME_formato_horizontal_pista + TEXT_TYPE + COMMA_SEP +
                    ComplementEntry.COLUMN_NAME_separacao_fisica_central + TEXT_TYPE + COMMA_SEP +
                    ComplementEntry.COLUMN_NAME_numero_faixas + TEXT_TYPE + COMMA_SEP +
                    ComplementEntry.COLUMN_NAME_velocidade_maxima + TEXT_TYPE + COMMA_SEP +
                    ComplementEntry.COLUMN_NAME_sinalizacao_vertical + TEXT_TYPE + COMMA_SEP +
                    ComplementEntry.COLUMN_NAME_sinalizacao_horizontal+ TEXT_TYPE + COMMA_SEP +
                    ComplementEntry.COLUMN_NAME_condicao_sinalizacao_semaforica + TEXT_TYPE + COMMA_SEP +
                    ComplementEntry.COLUMN_NAME_local_proximo_acidente + TEXT_TYPE + COMMA_SEP +
                    ComplementEntry.COLUMN_NAME_controle_trefego + TEXT_TYPE + COMMA_SEP +
                    ComplementEntry.COLUMN_NAME_trecho_local + TEXT_TYPE +COMMA_SEP+
                    ComplementEntry.COLUMN_NAME_id_boat +TEXT_TYPE+COMMA_SEP+

                    " FOREIGN KEY" + " (" +  ComplementEntry.COLUMN_NAME_id_boat + ") " + " REFERENCES " + BoatEntry.TABLE_NAME + " (" + BoatEntry.COLUMN_NAME_codigo + ") " +
                    ") ";

    // *** BOAT_ACIDENTE TABLE *** //

    public static class Boat_AcidenteEntry implements BaseColumns{
        public static final String TABLE_NAME ="boat_acidente";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_id_boat = "id_boat";
        public static final String COLUMN_NAME_id_tipo_acidente = "id_tipo_acidente";
        public static final String COLUMN_NAME_marcacao= "marcacao";
    }

    public static final String CREATE_BOAT_ACIDENTE =
            "CREATE TABLE " +" IF NOT EXISTS " + Boat_AcidenteEntry.TABLE_NAME +" (" +
                    Boat_AcidenteEntry.COLUMN_NAME_codigo + INTEGER_TYPE +" PRIMARY KEY"+ COMMA_SEP +
                    Boat_AcidenteEntry.COLUMN_NAME_id_boat +TEXT_TYPE + COMMA_SEP+
                    Boat_AcidenteEntry.COLUMN_NAME_id_tipo_acidente + TEXT_TYPE + COMMA_SEP+
                    Boat_AcidenteEntry.COLUMN_NAME_marcacao +TEXT_TYPE+ COMMA_SEP+
                    " FOREIGN KEY " + " (" +  Boat_AcidenteEntry.COLUMN_NAME_id_boat + ") " + " REFERENCES " + BoatEntry.TABLE_NAME + " (" + BoatEntry.COLUMN_NAME_codigo + ") " + COMMA_SEP+
                    " FOREIGN KEY " + " (" +  Boat_AcidenteEntry.COLUMN_NAME_id_tipo_acidente + ") " + " REFERENCES " + Tipo_AcidenteEntry.TABLE_NAME + " (" + Tipo_AcidenteEntry.COLUMN_NAME_codigo + ") " +
                    ") ";


    // *** TIPO_ACIDENTE TABLE *** //

    public static class Tipo_AcidenteEntry implements BaseColumns{
        public static final String TABLE_NAME ="tipo_acidente";
        public static final String COLUMN_NAME_codigo= "codigo";
        public static final String COLUMN_NAME_nome = "nome";
    }

    public static final String CREATE_TIPO_ACIDENTE =
            "CREATE TABLE " +" IF NOT EXITS " + Tipo_AcidenteEntry.TABLE_NAME +" (" +
                    Tipo_AcidenteEntry.COLUMN_NAME_codigo + INTEGER_TYPE +" PRIMARY KEY"+ COMMA_SEP +
                    Tipo_AcidenteEntry.COLUMN_NAME_nome +TEXT_TYPE +
                    ") ";

    // *** TIPO_AGENTE TABLE *** //
    public static class Tipo_AgenteEntry implements BaseColumns{
        public static final String TABLE_NAME ="tipo_agente";
        public static final String COLUMN_NAME_codigo= "codigo";
        public static final String COLUMN_NAME_especie = "especie";
    }
    public static final String CREATE_TIPO_AGENTE =
            "CREATE TABLE " +" IF NOT EXISTS " + Tipo_AgenteEntry.TABLE_NAME +" (" +
                    Tipo_AgenteEntry.COLUMN_NAME_codigo + INTEGER_TYPE +" PRIMARY KEY"+ COMMA_SEP +
                    Tipo_AgenteEntry.COLUMN_NAME_especie +TEXT_TYPE +
                    ") ";

    // *** AGENTE_ENVOLVIDO TABLE *** //
    public static class Agente_EnvolvidoEntry implements BaseColumns{
        public static final String TABLE_NAME ="agente_envolvido";
        public static final String COLUMN_NAME_matricula= "matricula";
        public static final String COLUMN_NAME_nome = "nome";
        public static final String COLUMN_NAME_prefixo = "prefixo";
        public static final String COLUMN_NAME_horario_chegada = "horario_chegada";
        public static final String COLUMN_NAME_chefe = "chefe";
        public static final String COLUMN_NAME_orgao = "orgao";
        public static final String COLUMN_NAME_id_boat="id_boat";
    }
    public static final String CREATE_AGENTE_ENVOLVIDO =
            "CREATE TABLE " +" IF NOT EXISTS " + Agente_EnvolvidoEntry.TABLE_NAME +" (" +
                    Agente_EnvolvidoEntry.COLUMN_NAME_matricula + TEXT_TYPE +" PRIMARY KEY"+ COMMA_SEP +
                    Agente_EnvolvidoEntry.COLUMN_NAME_nome +TEXT_TYPE + COMMA_SEP +
                    Agente_EnvolvidoEntry.COLUMN_NAME_prefixo+TEXT_TYPE + COMMA_SEP +
                    Agente_EnvolvidoEntry.COLUMN_NAME_horario_chegada +TEXT_TYPE + COMMA_SEP +
                    Agente_EnvolvidoEntry.COLUMN_NAME_chefe +TEXT_TYPE + COMMA_SEP +
                    Agente_EnvolvidoEntry.COLUMN_NAME_orgao +TEXT_TYPE + COMMA_SEP +
                    Agente_EnvolvidoEntry.COLUMN_NAME_id_boat +TEXT_TYPE +COMMA_SEP+
                    " FOREIGN KEY" + " (" +  Agente_EnvolvidoEntry.COLUMN_NAME_id_boat + ") " + " REFERENCES " + BoatEntry.TABLE_NAME + " (" + BoatEntry.COLUMN_NAME_codigo + ") "+
                    " )";
    // ***BOAT RELATORIO TABLLE ****//

    public static class Boat_RelatorioEntry implements BaseColumns{
        public static final String TABLE_NAME="boat_relatorio";
        public static final String COLUMN_NAME_codigo ="codigo";
        public static final String COLUMN_NAME_id_Condutor = "codigo_condutor";
        public static final String COLUMN_NAME_id_veiculo= "placa_veiculo";
        public static final String COLUMN_NAME_data_boat = "data_boat";
        public static final String COLUMN_NAME_id_boat = "id_boat";
        public static final String COLUMN_NAME_codigo_vbc = "codigo_vbc";
    }
    public static final String CREATE_BOAT_RELATORIO =
            "CREATE TABLE " +" IF NOT EXISTS "+ Boat_RelatorioEntry.TABLE_NAME +" (" +
                    Boat_RelatorioEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY "+COMMA_SEP +
                    Boat_RelatorioEntry.COLUMN_NAME_id_Condutor+TEXT_TYPE+COMMA_SEP+
                    Boat_RelatorioEntry.COLUMN_NAME_id_veiculo+TEXT_TYPE+COMMA_SEP+
                    Boat_RelatorioEntry.COLUMN_NAME_data_boat+TEXT_TYPE+COMMA_SEP+
                    Boat_RelatorioEntry.COLUMN_NAME_id_boat+TEXT_TYPE+COMMA_SEP+
                    Boat_RelatorioEntry.COLUMN_NAME_codigo_vbc+TEXT_TYPE+COMMA_SEP+

                    " FOREIGN KEY" + " (" +  Boat_RelatorioEntry.COLUMN_NAME_id_Condutor + ") " + " REFERENCES " + CondutorEntry.TABLE_NAME + " (" + CondutorEntry.COLUMN_NAME_codigoconductor + ") "+COMMA_SEP+
                    " FOREIGN KEY" + " (" +  Boat_RelatorioEntry.COLUMN_NAME_id_veiculo + ") " + " REFERENCES " + VEICULOEntry.TABLE_NAME + " (" + VEICULOEntry.COLUMN_NAME_placa + ") " + COMMA_SEP+
                    " FOREIGN KEY" + " (" +  Boat_RelatorioEntry.COLUMN_NAME_id_boat + ") " + " REFERENCES " + BoatEntry.TABLE_NAME + " (" + BoatEntry.COLUMN_NAME_codigo + ") " + COMMA_SEP+
                    " FOREIGN KEY" + " (" +  Boat_RelatorioEntry.COLUMN_NAME_codigo_vbc + ") " + " REFERENCES " + Veiculo_Boat_Entry.TABLE_NAME + " (" + Veiculo_Boat_Entry.COLUMN_NAME_codigo + ") " +
                    ") ";

            ;

    public static class BratEntry implements BaseColumns{
        public static final String TABLE_NAME="brat";
        public static final String COLUMN_NAME_codigo ="codigo";
        public static final String COLUMN_NAME_municipio = "municipio";
        public static final String COLUMN_NAME_data = "data";
        public static final String COLUMN_NAME_local = "local";
        public static final String COLUMN_NAME_local2 = "local2";
        public static final String COLUMN_NAME_tipo_local = "tipo_local";
        public static final String COLUMN_NAME_condicao = "condicao";
        public static final String COLUMN_NAME_sinalizacao = "sinalizacao";
        public static final String COLUMN_NAME_acidente = "acidente";
        public static final String COLUMN_NAME_natureza = "natureza";
        public static final String COLUMN_NAME_descricao = "descricao";
        public static final String COLUMN_NAME_observacoes = "observacoes";
        public static final String COLUMN_NAME_situacao = "situacao";
        public static final String COLUMN_NAME_operacao = "operacao";
        public static final String COLUMN_NAME_usuario = "usuario";
        public static final String COLUMN_NAME_pim = "pim";
        public static final String COLUMN_NAME_imei = "imei";
        public static final String COLUMN_NAME_versao = "versao";
        public static final String COLUMN_NAME_latitude = "latitude";
        public static final String COLUMN_NAME_longitude = "longitude";
    }

    public static final String CREATE_BRAT =
            "CREATE TABLE " +" IF NOT EXISTS "+ BratEntry.TABLE_NAME +" (" +
                    BratEntry._ID + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    BratEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_municipio + TEXT_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_data + TEXT_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_local + TEXT_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_local2 + TEXT_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_tipo_local + TEXT_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_condicao + TEXT_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_sinalizacao + TEXT_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_acidente + TEXT_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_natureza + TEXT_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_descricao + TEXT_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_observacoes + TEXT_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_situacao + TEXT_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_operacao + INTEGER_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_usuario + INTEGER_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_pim + TEXT_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_imei + TEXT_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_versao + TEXT_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_latitude + TEXT_TYPE + COMMA_SEP +
                    BratEntry.COLUMN_NAME_longitude + TEXT_TYPE + ") ";

    public static class BratEnvolvidoEntry implements BaseColumns{
        public static final String TABLE_NAME="brat_envolvido";
        public static final String COLUMN_NAME_codigo ="codigo";
        public static final String COLUMN_NAME_id_brat = "id_brat";
        public static final String COLUMN_NAME_codigo_brat = "codigo_brat";
        public static final String COLUMN_NAME_usuario = "usuario";
        public static final String COLUMN_NAME_tipo = "tipo";
        public static final String COLUMN_NAME_cpf = "cpf";
        public static final String COLUMN_NAME_nome = "nome";
        public static final String COLUMN_NAME_data_nascimento = "data_nascimento";
        public static final String COLUMN_NAME_sexo = "sexo";
        public static final String COLUMN_NAME_estado_civil = "estado_civil";
        public static final String COLUMN_NAME_cnh = "cnh";
        public static final String COLUMN_NAME_uf_cnh = "uf_cnh";
        public static final String COLUMN_NAME_validade = "validade";
        public static final String COLUMN_NAME_categoria = "categoria";
        public static final String COLUMN_NAME_identidade = "identidade";
        public static final String COLUMN_NAME_orgao = "orgao";
        public static final String COLUMN_NAME_uf_identidade = "uf_identidade";
        public static final String COLUMN_NAME_endereco = "endereco";
        public static final String COLUMN_NAME_complemento = "complemento";
        public static final String COLUMN_NAME_bairro = "bairro";
        public static final String COLUMN_NAME_municipio = "municipio";
        public static final String COLUMN_NAME_cep = "cep";
        public static final String COLUMN_NAME_sem_ferimentos = "sem_ferimentos";
        public static final String COLUMN_NAME_leves = "leves";
        public static final String COLUMN_NAME_graves = "graves";
        public static final String COLUMN_NAME_fatais = "fatais";
        public static final String COLUMN_NAME_auto_lesao = "auto_lesao";
        public static final String COLUMN_NAME_danos = "danos";
        public static final String COLUMN_NAME_veiculo_oficial = "veiculo_oficial";
        public static final String COLUMN_NAME_evadiu = "evadiu";
        public static final String COLUMN_NAME_veiculo = "veiculo";
        public static final String COLUMN_NAME_removido = "removido";
        public static final String COLUMN_NAME_placa = "placa";
        public static final String COLUMN_NAME_operacao = "operacao";
    }

    public static final String CREATE_BRAT_ENVOLVIDO =
            "CREATE TABLE " +" IF NOT EXISTS "+ BratEnvolvidoEntry.TABLE_NAME +" (" +
                    BratEnvolvidoEntry._ID + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_id_brat + INTEGER_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_codigo_brat + INTEGER_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_usuario + INTEGER_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_tipo + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_cpf + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_nome + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_data_nascimento + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_sexo + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_estado_civil + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_cnh + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_uf_cnh + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_validade + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_categoria + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_identidade + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_orgao + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_uf_identidade + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_endereco + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_complemento + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_bairro + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_municipio + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_cep + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_sem_ferimentos + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_leves + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_graves + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_fatais + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_auto_lesao + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_danos + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_veiculo_oficial + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_evadiu + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_veiculo + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_removido + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_placa + TEXT_TYPE + COMMA_SEP +
                    BratEnvolvidoEntry.COLUMN_NAME_operacao + INTEGER_TYPE +
                    ") ";

    public static class BratVeiculoEntry implements BaseColumns {
        public static final String TABLE_NAME = "brat_veiculo";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_id_brat = "id_brat";
        public static final String COLUMN_NAME_codigo_brat = "codigo_brat";
        public static final String COLUMN_NAME_usuario = "usuario";
        public static final String COLUMN_NAME_placa = "placa";
        public static final String COLUMN_NAME_marca = "marca";
        public static final String COLUMN_NAME_cor = "cor";
        public static final String COLUMN_NAME_ano_ultimo_licenciamento = "ano_ultimo_licenciamento";
        public static final String COLUMN_NAME_renavam = "renavam";
        public static final String COLUMN_NAME_chassi = "chassi";
        public static final String COLUMN_NAME_tipo = "tipo";
        public static final String COLUMN_NAME_especie = "especie";
        public static final String COLUMN_NAME_categora = "categoria";
        public static final String COLUMN_NAME_ano_fabricacao = "ano_fabricacao";
        public static final String COLUMN_NAME_ano_modelo = "ano_modelo";
        public static final String COLUMN_NAME_uf = "uf";
        public static final String COLUMN_NAME_municipio = "municipio";
        public static final String COLUMN_NAME_cpf_proprietario = "cpf_proprietario";
        public static final String COLUMN_NAME_nome_proprietario = "nome_proprietario";
        public static final String COLUMN_NAME_situacao_veiculo = "situacao_veiculo";
        public static final String COLUMN_NAME_danos = "danos";
        public static final String COLUMN_NAME_danos1 = "danos1";
        public static final String COLUMN_NAME_danos2 = "danos2";
        public static final String COLUMN_NAME_danos3 = "danos3";
        public static final String COLUMN_NAME_danos4 = "danos4";
        public static final String COLUMN_NAME_danos5 = "danos5";
        public static final String COLUMN_NAME_danos6 = "danos6";
        public static final String COLUMN_NAME_danos7 = "danos7";
        public static final String COLUMN_NAME_danos8 = "danos8";
        public static final String COLUMN_NAME_danos9 = "danos9";
        public static final String COLUMN_NAME_danos10 = "danos10";
        public static final String COLUMN_NAME_danos11 = "danos11";
        public static final String COLUMN_NAME_danos12 = "danos12";
        public static final String COLUMN_NAME_danos13 = "danos13";
        public static final String COLUMN_NAME_danos14 = "danos14";
        public static final String COLUMN_NAME_danos15 = "danos15";
        public static final String COLUMN_NAME_danos16 = "danos16";
        public static final String COLUMN_NAME_operacao = "operacao";
    }

    public static final String CREATE_BRAT_VEICULO =
            "CREATE TABLE " +" IF NOT EXISTS "+ BratVeiculoEntry.TABLE_NAME +" (" +
                    BratVeiculoEntry._ID + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_id_brat + INTEGER_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_codigo_brat + INTEGER_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_usuario + INTEGER_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_placa + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_marca + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_cor + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_ano_ultimo_licenciamento + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_renavam + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_chassi + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_tipo + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_especie + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_categora + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_ano_fabricacao + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_ano_modelo + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_uf + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_municipio + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_cpf_proprietario + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_nome_proprietario + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_situacao_veiculo + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos1 + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos2 + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos3 + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos4 + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos5 + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos6 + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos7 + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos8 + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos9 + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos10 + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos11 + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos12 + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos13 + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos14 + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos15 + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_danos16 + TEXT_TYPE + COMMA_SEP +
                    BratVeiculoEntry.COLUMN_NAME_operacao + INTEGER_TYPE +
                    ") ";

    public static class BratViaturaEntry implements BaseColumns {
        public static final String TABLE_NAME = "brat_viatura";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_id_brat = "id_brat";
        public static final String COLUMN_NAME_codigo_brat = "codigo_brat";
        public static final String COLUMN_NAME_usuario = "usuario";
        public static final String COLUMN_NAME_prefixo = "prefixo";
        public static final String COLUMN_NAME_responsavel = "responsavel";
        public static final String COLUMN_NAME_matricula = "matricula";
        public static final String COLUMN_NAME_socorro = "socorro";
        public static final String COLUMN_NAME_tipo_socorro = "tipo_socorro";
        public static final String COLUMN_NAME_outro_tipo_socorro = "outro_tipo_socorro";
        public static final String COLUMN_NAME_pericia = "pericia";
        public static final String COLUMN_NAME_operacao = "operacao";
    }

    public static final String CREATE_BRAT_VIATURA =
            "CREATE TABLE " +" IF NOT EXISTS "+ BratViaturaEntry.TABLE_NAME +" (" +
                    BratViaturaEntry._ID + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    BratViaturaEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    BratViaturaEntry.COLUMN_NAME_id_brat + INTEGER_TYPE + COMMA_SEP +
                    BratViaturaEntry.COLUMN_NAME_codigo_brat + INTEGER_TYPE + COMMA_SEP +
                    BratViaturaEntry.COLUMN_NAME_usuario + INTEGER_TYPE + COMMA_SEP +
                    BratViaturaEntry.COLUMN_NAME_prefixo + TEXT_TYPE + COMMA_SEP +
                    BratViaturaEntry.COLUMN_NAME_responsavel + TEXT_TYPE + COMMA_SEP +
                    BratViaturaEntry.COLUMN_NAME_matricula + TEXT_TYPE + COMMA_SEP +
                    BratViaturaEntry.COLUMN_NAME_socorro + TEXT_TYPE + COMMA_SEP +
                    BratViaturaEntry.COLUMN_NAME_tipo_socorro + TEXT_TYPE + COMMA_SEP +
                    BratViaturaEntry.COLUMN_NAME_outro_tipo_socorro + TEXT_TYPE + COMMA_SEP +
                    BratViaturaEntry.COLUMN_NAME_pericia + TEXT_TYPE + COMMA_SEP +
                    BratViaturaEntry.COLUMN_NAME_operacao + INTEGER_TYPE +
                    ") ";

    public static class BratFotoEntry implements BaseColumns {
        public static final String TABLE_NAME = "brat_foto";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_id_brat = "id_brat";
        public static final String COLUMN_NAME_codigo_brat = "codigo_brat";
        public static final String COLUMN_NAME_foto = "foto";
        public static final String COLUMN_NAME_path = "path";
        public static final String COLUMN_NAME_tipo = "tipo";
        public static final String COLUMN_NAME_origem = "origem";
        public static final String COLUMN_NAME_operacao = "operacao";
    }

    public static final String CREATE_BRAT_FOTO =
            "CREATE TABLE " +" IF NOT EXISTS "+ BratFotoEntry.TABLE_NAME +" (" +
                    BratFotoEntry._ID + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    BratFotoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    BratFotoEntry.COLUMN_NAME_id_brat + INTEGER_TYPE + COMMA_SEP +
                    BratFotoEntry.COLUMN_NAME_codigo_brat + INTEGER_TYPE + COMMA_SEP +
                    BratFotoEntry.COLUMN_NAME_foto + BLOB_TYPE + COMMA_SEP +
                    BratFotoEntry.COLUMN_NAME_path + TEXT_TYPE + COMMA_SEP +
                    BratFotoEntry.COLUMN_NAME_tipo + TEXT_TYPE + COMMA_SEP +
                    BratFotoEntry.COLUMN_NAME_origem + INTEGER_TYPE + COMMA_SEP +
                    BratFotoEntry.COLUMN_NAME_operacao + INTEGER_TYPE +
                    ") ";

    public static class ComplementoMunicipioEntry implements BaseColumns{
        public static final String TABLE_NAME = "complemento_municipio";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_codigo_municipio = "codigo_municipio";
        public static final String COLUMN_NAME_nome = "nome";
    }

    public static final String CREATE_COMPLMENTO_MUNICIPIO =
            "CREATE TABLE " +" IF NOT EXISTS "+ ComplementoMunicipioEntry.TABLE_NAME +" (" +
                    ComplementoMunicipioEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    ComplementoMunicipioEntry.COLUMN_NAME_codigo_municipio + INTEGER_TYPE + COMMA_SEP +
                    ComplementoMunicipioEntry.COLUMN_NAME_nome + TEXT_TYPE +
                    ") ";

    public static class ItemDespachoEntry implements BaseColumns{
        public static final String TABLE_NAME = "itens_despacho";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_tipo = "tipo";
        public static final String COLUMN_NAME_item = "item";
    }

    public static final String CREATE_ITENS_DESPACHO =
            "CREATE TABLE " +" IF NOT EXISTS "+ ItemDespachoEntry.TABLE_NAME +" (" +
                    ItemDespachoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    ItemDespachoEntry.COLUMN_NAME_tipo + TEXT_TYPE + COMMA_SEP +
                    ItemDespachoEntry.COLUMN_NAME_item + TEXT_TYPE +
                    ") ";

    public static class NaoConformidadeDespachoEntry implements BaseColumns{
        public static final String TABLE_NAME = "nao_conformidade_despacho";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_descricao = "descricao";
    }

    public static final String CREATE_NAO_CONFORMIDADE_DESPACHO =
            "CREATE TABLE IF NOT EXISTS "+ NaoConformidadeDespachoEntry.TABLE_NAME +" (" +
                    NaoConformidadeDespachoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    NaoConformidadeDespachoEntry.COLUMN_NAME_descricao + TEXT_TYPE +
                    ") ";

    public static class DespachoViaturaEntry implements BaseColumns{
        public static final String TABLE_NAME = "despacho_viatura";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_data = "data";
        public static final String COLUMN_NAME_tipo = "tipo";
        public static final String COLUMN_NAME_placa = "placa";
        public static final String COLUMN_NAME_local_saida = "local_saida";
        public static final String COLUMN_NAME_hora_saida = "hora_saida";
        public static final String COLUMN_NAME_hora_chegada = "hora_chegada";
        public static final String COLUMN_NAME_destino = "destino";
        public static final String COLUMN_NAME_condutor = "condutor";
        public static final String COLUMN_NAME_matricula = "matricula";
        public static final String COLUMN_NAME_codigo_abastecimento = "codigo_abastecimento";
        public static final String COLUMN_NAME_odometro_saida = "odometro_saida";
        public static final String COLUMN_NAME_odometro_chegada = "odometro_chegada";
        public static final String COLUMN_NAME_combustivel = "combustivel";
        public static final String COLUMN_NAME_anotacoes = "anotacoes";
        public static final String COLUMN_NAME_cones = "cones";
        public static final String COLUMN_NAME_cavaletes = "cavaletes";
        public static final String COLUMN_NAME_fitas = "fitas";
        public static final String COLUMN_NAME_outros = "outros";
        public static final String COLUMN_NAME_situacao = "situacao";
        public static final String COLUMN_NAME_usuario = "usuario";
        public static final String COLUMN_NAME_pim = "pim";
        public static final String COLUMN_NAME_imei = "imei";
        public static final String COLUMN_NAME_versao = "versao";
        public static final String COLUMN_NAME_operacao = "operacao";
    }

    public static final String CREATE_DESPACHO_VIATURA =
            "CREATE TABLE IF NOT EXISTS "+ DespachoViaturaEntry.TABLE_NAME +" (" +
                    DespachoViaturaEntry._ID + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_data + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_tipo + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_placa + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_local_saida + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_hora_saida + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_hora_chegada + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_destino + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_condutor + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_matricula + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_codigo_abastecimento + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_odometro_saida + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_odometro_chegada + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_combustivel + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_anotacoes + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_cones + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_cavaletes + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_fitas + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_outros + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_situacao + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_usuario + INTEGER_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_pim + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_imei + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_versao + TEXT_TYPE + COMMA_SEP +
                    DespachoViaturaEntry.COLUMN_NAME_operacao + INTEGER_TYPE +
                    ") ";

    public static class DespachoFotoEntry implements BaseColumns{
        public static final String TABLE_NAME = "despacho_foto";
        public static final String COLUMN_NAME_id_despacho = "id_despacho";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_tipo = "tipo";
        public static final String COLUMN_NAME_foto = "foto";
        public static final String COLUMN_NAME_origem = "origem";
        public static final String COLUMN_NAME_operacao = "operacao";
    }

    public static final String CREATE_DESPACHO_FOTO =
            "CREATE TABLE IF NOT EXISTS " + DespachoFotoEntry.TABLE_NAME +" (" +
                    DespachoFotoEntry._ID + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    DespachoFotoEntry.COLUMN_NAME_id_despacho + INTEGER_TYPE + COMMA_SEP +
                    DespachoFotoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    DespachoFotoEntry.COLUMN_NAME_tipo + TEXT_TYPE + COMMA_SEP +
                    DespachoFotoEntry.COLUMN_NAME_foto + BLOB_TYPE + COMMA_SEP +
                    DespachoFotoEntry.COLUMN_NAME_origem + INTEGER_TYPE + COMMA_SEP +
                    DespachoFotoEntry.COLUMN_NAME_operacao + INTEGER_TYPE +
                    ") ";

    public static class DespachoItemEntry implements BaseColumns{
        public static final String TABLE_NAME = "despacho_item";
        public static final String COLUMN_NAME_id_despacho = "id_despacho";
        public static final String COLUMN_NAME_id_item = "id_item";
        public static final String COLUMN_NAME_marcacao = "tipo";
//        public static final String COLUMN_NAME_operacao = "operacao";
    }

    public static final String CREATE_DESPACHO_ITEM =
            "CREATE TABLE IF NOT EXISTS " + DespachoItemEntry.TABLE_NAME +" (" +
                    DespachoItemEntry.COLUMN_NAME_id_despacho + INTEGER_TYPE + " NOT NULL" + COMMA_SEP +
                    DespachoItemEntry.COLUMN_NAME_id_item + INTEGER_TYPE + " NOT NULL" + COMMA_SEP +
                    DespachoItemEntry.COLUMN_NAME_marcacao + TEXT_TYPE + COMMA_SEP +
                    "PRIMARY KEY (" +
                    DespachoItemEntry.COLUMN_NAME_id_despacho + COMMA_SEP +
                    DespachoItemEntry.COLUMN_NAME_id_item + ")" +
                    ") ";

    public static class DespachoNaoConformidadeEntry implements BaseColumns{
        public static final String TABLE_NAME = "despacho_nao_conformidade";
        public static final String COLUMN_NAME_id_despacho = "id_despacho";
        public static final String COLUMN_NAME_id_item = "id_item";
        public static final String COLUMN_NAME_marcacao = "tipo";
//        public static final String COLUMN_NAME_operacao = "operacao";
    }

    public static final String CREATE_DESPACHO_NAO_CONFORMIDADE =
            "CREATE TABLE IF NOT EXISTS " + DespachoNaoConformidadeEntry.TABLE_NAME +" (" +
                    DespachoNaoConformidadeEntry.COLUMN_NAME_id_despacho + INTEGER_TYPE + " NOT NULL" + COMMA_SEP +
                    DespachoNaoConformidadeEntry.COLUMN_NAME_id_item + INTEGER_TYPE + " NOT NULL" + COMMA_SEP +
                    DespachoNaoConformidadeEntry.COLUMN_NAME_marcacao + TEXT_TYPE + COMMA_SEP +
                    "PRIMARY KEY (" +
                    DespachoNaoConformidadeEntry.COLUMN_NAME_id_despacho + COMMA_SEP +
                    DespachoNaoConformidadeEntry.COLUMN_NAME_id_item + ")" +
                    ") ";


    //relatorio de fiscalizacao
    public static class RelatorioFiscalizacaoEntry implements BaseColumns{
        public static final String TABLE_NAME = "relatorio_fiscalizacao";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_evento = "evento";
        public static final String COLUMN_NAME_data = "data";
        public static final String COLUMN_NAME_hora_inicial = "hora_inicial";
        public static final String COLUMN_NAME_hora_final = "hora_final";
        public static final String COLUMN_NAME_setor = "setor";
        public static final String COLUMN_NAME_supervisor = "supervisor";
        public static final String COLUMN_NAME_agente = "agente";
        public static final String COLUMN_NAME_automovel = "automovel";
        public static final String COLUMN_NAME_motocicleta = "motocicleta";
        public static final String COLUMN_NAME_cavalete = "cavalete";
        public static final String COLUMN_NAME_cone = "cone";
        public static final String COLUMN_NAME_outros = "outros";
        public static final String COLUMN_NAME_desenvolvimento = "desenvolvimento";
        public static final String COLUMN_NAME_obs = "obs";
        public static final String COLUMN_NAME_usuario = "usuario";
        public static final String COLUMN_NAME_pim = "pim";
        public static final String COLUMN_NAME_imei = "imei";
        public static final String COLUMN_NAME_versao = "versao";
        public static final String COLUMN_NAME_operacao = "operacao";
    }

    public static final String CREATE_RELATORIO_FISCALIZACAO =
            "CREATE TABLE IF NOT EXISTS " + RelatorioFiscalizacaoEntry.TABLE_NAME +" (" +
                    RelatorioFiscalizacaoEntry._ID + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_evento + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_data + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_hora_inicial + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_hora_final + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_setor + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_supervisor + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_agente + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_automovel + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_motocicleta + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_cavalete + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_cone + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_outros + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_desenvolvimento + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_obs + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_usuario + INTEGER_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_pim + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_imei + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_versao + TEXT_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEntry.COLUMN_NAME_operacao + INTEGER_TYPE +
                    ") ";

    public static class RelatorioFiscalizacaoEfetivoEntry implements BaseColumns{
        public static final String TABLE_NAME = "relatorio_fiscalizacao_efetivo";
        public static final String COLUMN_NAME_id_relatorio = "id_relatorio";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_efetivo = "efetivo";
        //public static final String COLUMN_NAME_operacao = "operacao";
    }

    public static final String CREATE_RELATORIO_FISCALIZACAO_EFETIVO =
            "CREATE TABLE IF NOT EXISTS " + RelatorioFiscalizacaoEfetivoEntry.TABLE_NAME +" (" +
                    RelatorioFiscalizacaoEfetivoEntry._ID + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    RelatorioFiscalizacaoEfetivoEntry.COLUMN_NAME_id_relatorio + INTEGER_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEfetivoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoEfetivoEntry.COLUMN_NAME_efetivo + TEXT_TYPE +
                    ") ";

    public static class RelatorioFiscalizacaoLocalEntry implements BaseColumns{
        public static final String TABLE_NAME = "relatorio_fiscalizacao_local";
        public static final String COLUMN_NAME_id_relatorio = "id_relatorio";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_local = "local";
        //public static final String COLUMN_NAME_operacao = "operacao";
    }

    public static final String CREATE_RELATORIO_FISCALIZACAO_LOCAL =
            "CREATE TABLE IF NOT EXISTS " + RelatorioFiscalizacaoLocalEntry.TABLE_NAME +" (" +
                    RelatorioFiscalizacaoLocalEntry._ID + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    RelatorioFiscalizacaoLocalEntry.COLUMN_NAME_id_relatorio + INTEGER_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoLocalEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    RelatorioFiscalizacaoLocalEntry.COLUMN_NAME_local + TEXT_TYPE +
                    ") ";

    //Inicio pontos interesse
    public static class TipoMapeamentoEntry implements BaseColumns{
        public static final String TABLE_NAME = "tipo_mapeamento";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_tipo = "tipo";
    }

    public static final String CREATE_TIPO_MAPEAMENTO =
            "CREATE TABLE IF NOT EXISTS " + TipoMapeamentoEntry.TABLE_NAME +" (" +
                    TipoMapeamentoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    TipoMapeamentoEntry.COLUMN_NAME_tipo + TEXT_TYPE +
                    ") ";

    public static class PontoInteresseEntry implements BaseColumns{
        public static final String TABLE_NAME = "ponto_interesso";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_endereco = "endereco";
        public static final String COLUMN_NAME_tipo = "tipo";
        public static final String COLUMN_NAME_sinalizacao = "sinalizacao";
        public static final String COLUMN_NAME_obs = "obs";
        public static final String COLUMN_NAME_usuario = "usuario";
        public static final String COLUMN_NAME_latitude = "latitude";
        public static final String COLUMN_NAME_longitude = "longitude";
        public static final String COLUMN_NAME_pim = "pim";
        public static final String COLUMN_NAME_imei = "imei";
        public static final String COLUMN_NAME_versao = "versao";
        public static final String COLUMN_NAME_operacao = "operacao";
    }

    public static final String CREATE_PONTO_INTERESSE =
            "CREATE TABLE IF NOT EXISTS " + PontoInteresseEntry.TABLE_NAME +" (" +
                    PontoInteresseEntry._ID + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    PontoInteresseEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    PontoInteresseEntry.COLUMN_NAME_endereco + TEXT_TYPE + COMMA_SEP +
                    PontoInteresseEntry.COLUMN_NAME_tipo + INTEGER_TYPE + COMMA_SEP +
                    PontoInteresseEntry.COLUMN_NAME_sinalizacao + TEXT_TYPE + COMMA_SEP +
                    PontoInteresseEntry.COLUMN_NAME_obs + TEXT_TYPE + COMMA_SEP +
                    PontoInteresseEntry.COLUMN_NAME_usuario + INTEGER_TYPE + COMMA_SEP +
                    PontoInteresseEntry.COLUMN_NAME_latitude + TEXT_TYPE + COMMA_SEP +
                    PontoInteresseEntry.COLUMN_NAME_longitude + TEXT_TYPE + COMMA_SEP +
                    PontoInteresseEntry.COLUMN_NAME_pim + TEXT_TYPE + COMMA_SEP +
                    PontoInteresseEntry.COLUMN_NAME_imei + TEXT_TYPE + COMMA_SEP +
                    PontoInteresseEntry.COLUMN_NAME_versao + TEXT_TYPE + COMMA_SEP +
                    PontoInteresseEntry.COLUMN_NAME_operacao + INTEGER_TYPE +
                    ") ";

    public static class PontoInteresseFotoEntry implements BaseColumns {
        public static final String TABLE_NAME = "ponto_interesse_foto";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_id_ponto = "id_ponto";
        public static final String COLUMN_NAME_foto = "foto";
        public static final String COLUMN_NAME_path = "path";
        public static final String COLUMN_NAME_origem = "origem";
        public static final String COLUMN_NAME_operacao = "operacao";
    }

    public static final String CREATE_PONTO_INTERESSE_FOTO =
            "CREATE TABLE " +" IF NOT EXISTS "+ PontoInteresseFotoEntry.TABLE_NAME +" (" +
                    PontoInteresseFotoEntry._ID + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    PontoInteresseFotoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    PontoInteresseFotoEntry.COLUMN_NAME_id_ponto + INTEGER_TYPE + COMMA_SEP +
                    PontoInteresseFotoEntry.COLUMN_NAME_foto + BLOB_TYPE + COMMA_SEP +
                    PontoInteresseFotoEntry.COLUMN_NAME_path + TEXT_TYPE + COMMA_SEP +
                    PontoInteresseFotoEntry.COLUMN_NAME_origem + INTEGER_TYPE + COMMA_SEP +
                    PontoInteresseFotoEntry.COLUMN_NAME_operacao + INTEGER_TYPE +
                    ") ";
    //Final pontos interesse

    //Inicio municipio
    public static class MunicipioEntry implements BaseColumns {
        public static final String TABLE_NAME = "municipio";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_nome = "nome";
        public static final String COLUMN_NAME_uf = "uf";
    }

    public static final String CREATE_MUNICIPIO =
            "CREATE TABLE " +" IF NOT EXISTS "+ MunicipioEntry.TABLE_NAME +" (" +
                    MunicipioEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    MunicipioEntry.COLUMN_NAME_nome + TEXT_TYPE + COMMA_SEP +
                    MunicipioEntry.COLUMN_NAME_uf + TEXT_TYPE +
                    ") ";
    //final municipio

    //Inicio orgao
    public static class OrgaoEntry implements BaseColumns {
        public static final String TABLE_NAME = "orgao";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_nome = "nome";
        public static final String COLUMN_NAME_prefixo = "prefixo";
        public static final String COLUMN_NAME_competencia = "competencia";
    }

    public static final String CREATE_ORGAO =
            "CREATE TABLE " +" IF NOT EXISTS "+ OrgaoEntry.TABLE_NAME +" (" +
                    OrgaoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    OrgaoEntry.COLUMN_NAME_nome + TEXT_TYPE + COMMA_SEP +
                    OrgaoEntry.COLUMN_NAME_prefixo + TEXT_TYPE + COMMA_SEP +
                    OrgaoEntry.COLUMN_NAME_competencia + TEXT_TYPE +
                    ") ";
    //final orgao

    //Inicio observacao infracao
    public static class ObservacaoInfracaoEntry implements BaseColumns {
        public static final String TABLE_NAME = "observacao_infracao";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_observacao = "observacao";
    }

    public static final String CREATE_OBSERVACAO_INFRACAO =
            "CREATE TABLE " +" IF NOT EXISTS "+ ObservacaoInfracaoEntry.TABLE_NAME +" (" +
                    ObservacaoInfracaoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    ObservacaoInfracaoEntry.COLUMN_NAME_observacao + TEXT_TYPE +
                    ") ";
    //final observacao infracao
    //incio equipamento afericao
    public static class EquipamentoAfericaoEntry implements BaseColumns {
        public static final String TABLE_NAME = "equipamento_afericao";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_tipo_afericao = "tipo_afericao";
        public static final String COLUMN_NAME_numero = "numero";
        public static final String COLUMN_NAME_marca = "marca";
        public static final String COLUMN_NAME_modelo = "modelo";
        public static final String COLUMN_NAME_data_afericao = "data_afericao";
    }

    public static final String CREATE_EQUIPAMENTO_AFERICAO =
            "CREATE TABLE IF NOT EXISTS " + EquipamentoAfericaoEntry.TABLE_NAME + " (" +
                    EquipamentoAfericaoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    EquipamentoAfericaoEntry.COLUMN_NAME_tipo_afericao + INTEGER_TYPE + COMMA_SEP +
                    EquipamentoAfericaoEntry.COLUMN_NAME_numero + TEXT_TYPE + COMMA_SEP +
                    EquipamentoAfericaoEntry.COLUMN_NAME_marca + TEXT_TYPE + COMMA_SEP +
                    EquipamentoAfericaoEntry.COLUMN_NAME_modelo + TEXT_TYPE + COMMA_SEP +
                    EquipamentoAfericaoEntry.COLUMN_NAME_data_afericao + TEXT_TYPE +
                    " )";
    //final equipamento afericao

    //Inicio medicao alcoolemia
    public static class MedicaoAlcoolemiaEntry implements BaseColumns {
        public static final String TABLE_NAME = "medicao_alcoolemia";
        public static final String COLUMN_NAME_tipo = "tipo";
        public static final String COLUMN_NAME_realizada = "realizada";
        public static final String COLUMN_NAME_considerada = "considerada";
        public static final String COLUMN_NAME_limite = "limite";
    }

    public static final String CREATE_MEDICAO_ALCOOLEMIA =
            "CREATE TABLE " +" IF NOT EXISTS "+ MedicaoAlcoolemiaEntry.TABLE_NAME +" (" +
                    MedicaoAlcoolemiaEntry.COLUMN_NAME_tipo + INTEGER_TYPE + COMMA_SEP +
                    MedicaoAlcoolemiaEntry.COLUMN_NAME_realizada + TEXT_TYPE + COMMA_SEP +
                    MedicaoAlcoolemiaEntry.COLUMN_NAME_considerada + TEXT_TYPE + COMMA_SEP +
                    MedicaoAlcoolemiaEntry.COLUMN_NAME_limite + TEXT_TYPE +
                    ") ";
    //final medicao alcoolemia

    //Inicio tipo local
    public static class TipoLocalEntry implements BaseColumns {
        public static final String TABLE_NAME = "tipo_local";
        public static final String COLUMN_NAME_descricao = "descricao";
    }

    public static final String CREATE_TIPO_LOCAL =
            "CREATE TABLE " +" IF NOT EXISTS "+ TipoLocalEntry.TABLE_NAME +" (" +
                    TipoLocalEntry.COLUMN_NAME_descricao + TEXT_TYPE +
                    ") ";
    //final tipo local

    //Inicio tipo remocao
    public static class RemocaoEntry implements BaseColumns {
        public static final String TABLE_NAME = "apreensao";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_infracao = "infracao";
        public static final String COLUMN_NAME_infracao_data = "data_infracao";
        public static final String COLUMN_NAME_infracao_hora = "hora_infracao";
        public static final String COLUMN_NAME_auto = "auto";
        public static final String COLUMN_NAME_infracao_codigo = "codigo_infracao";
        public static final String COLUMN_NAME_infracao_desdobramento = "desdobramento_infracao";
        public static final String COLUMN_NAME_orgao = "orgao";
        public static final String COLUMN_NAME_placa = "placa";
        public static final String COLUMN_NAME_uf = "uf";
        public static final String COLUMN_NAME_marca = "marca";
        public static final String COLUMN_NAME_especie = "especie";
        public static final String COLUMN_NAME_cor = "cor";
        public static final String COLUMN_NAME_chassi = "chassi";
        public static final String COLUMN_NAME_restricao = "restricao";
        public static final String COLUMN_NAME_condutor_cpf = "cpf_condutor";
        public static final String COLUMN_NAME_condutor_nome = "nome_condutor";
        public static final String COLUMN_NAME_local_ocorrencia = "local_ocorrencia";
        public static final String COLUMN_NAME_agente_matricula = "matricula_agente";
        public static final String COLUMN_NAME_agente_nome = "nome_agente";
        public static final String COLUMN_NAME_entrada = "entrada";
        public static final String COLUMN_NAME_odometro_inicial = "odometro_inicial";
        public static final String COLUMN_NAME_odometro_final = "odometro_final";
        public static final String COLUMN_NAME_percurso = "percurso";
        public static final String COLUMN_NAME_guincho = "guincho";
        public static final String COLUMN_NAME_guincho_matricula = "matricula_guincho";
        public static final String COLUMN_NAME_guincho_condutor = "guincho_condutor";
        public static final String COLUMN_NAME_dva = "dva";
        public static final String COLUMN_NAME_patio = "patio";
        public static final String COLUMN_NAME_vaga = "vaga";
        public static final String COLUMN_NAME_fila = "fila";
        public static final String COLUMN_NAME_muro = "muro";
        public static final String COLUMN_NAME_chave_ignicao = "chave_ignicao";
        public static final String COLUMN_NAME_chave_ignicao_endereco = "chave_ignicao_endereco";
        public static final String COLUMN_NAME_combustivel = "combustivel";
        public static final String COLUMN_NAME_tacografo = "tacografo";
        public static final String COLUMN_NAME_obs = "obs";
        public static final String COLUMN_NAME_situacao = "situacao";
        public static final String COLUMN_NAME_data_recolhimento = "data_recolhimento";
        public static final String COLUMN_NAME_tipo_remocao = "tipo_remocao";
        public static final String COLUMN_NAME_opcao_atual = "opcao_atual";
        public static final String COLUMN_NAME_opcao_data = "data_opcao";
        public static final String COLUMN_NAME_usuario = "usuario";
        public static final String COLUMN_NAME_latitude = "latitude";
        public static final String COLUMN_NAME_longitude = "longitude";
        public static final String COLUMN_NAME_pim = "pim";
        public static final String COLUMN_NAME_imei = "imei";
        public static final String COLUMN_NAME_versao = "versao";
        public static final String COLUMN_NAME_operacao = "operacao";
    }
    public static final String CREATE_REMOCAO =
            "CREATE TABLE " +" IF NOT EXISTS "+ RemocaoEntry.TABLE_NAME +" (" +
                    RemocaoEntry._ID + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_infracao + INTEGER_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_infracao_data + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_infracao_hora + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_auto + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_infracao_codigo + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_infracao_desdobramento + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_orgao + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_placa + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_uf + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_marca + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_especie + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_cor + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_chassi + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_restricao + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_condutor_cpf + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_condutor_nome + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_local_ocorrencia + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_agente_matricula + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_agente_nome + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_entrada + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_odometro_inicial + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_odometro_final + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_percurso + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_guincho + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_guincho_matricula + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_guincho_condutor + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_dva + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_patio + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_vaga + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_fila + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_muro + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_chave_ignicao + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_chave_ignicao_endereco + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_combustivel + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_tacografo + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_obs + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_situacao + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_data_recolhimento + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_tipo_remocao + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_opcao_atual + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_opcao_data + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_usuario + INTEGER_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_pim + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_imei + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_latitude + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_longitude + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_versao + TEXT_TYPE + COMMA_SEP +
                    RemocaoEntry.COLUMN_NAME_operacao + TEXT_TYPE +
                    ") ";

    public static class RemocaoFotoEntry implements BaseColumns {
        public static final String TABLE_NAME = "apreensao_fotos";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_chave = "chave";
        public static final String COLUMN_NAME_tipo = "tipo";
        public static final String COLUMN_NAME_tipo_assinatura = "tipo_assinatura";
        public static final String COLUMN_NAME_origem = "origem";
        public static final String COLUMN_NAME_path = "caminho";
        public static final String COLUMN_NAME_foto = "foto";
    }
    public static final String CREATE_REMOCAO_FOTO =
            "CREATE TABLE IF NOT EXISTS " + RemocaoFotoEntry.TABLE_NAME + " (" +
                    RemocaoFotoEntry._ID + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    RemocaoFotoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    RemocaoFotoEntry.COLUMN_NAME_chave + INTEGER_TYPE + COMMA_SEP +
                    RemocaoFotoEntry.COLUMN_NAME_tipo + INTEGER_TYPE + COMMA_SEP +
                    RemocaoFotoEntry.COLUMN_NAME_tipo_assinatura + TEXT_TYPE + COMMA_SEP +
                    RemocaoFotoEntry.COLUMN_NAME_origem + INTEGER_TYPE + COMMA_SEP +
                    RemocaoFotoEntry.COLUMN_NAME_path + TEXT_TYPE + COMMA_SEP +
                    RemocaoFotoEntry.COLUMN_NAME_foto + IMAGE_TYPE +
                    ")";

    public static class RemocaoItemEntry implements BaseColumns {
        public static final String TABLE_NAME = "apreensao_itens";
        public static final String COLUMN_NAME_chave = "chave";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_tipo = "tipo";
        public static final String COLUMN_NAME_item1 = "item1";
        public static final String COLUMN_NAME_item2 = "item2";
        public static final String COLUMN_NAME_item3 = "item3";
        public static final String COLUMN_NAME_item4 = "item4";
        public static final String COLUMN_NAME_item5 = "item5";
        public static final String COLUMN_NAME_item6 = "item6";
        public static final String COLUMN_NAME_item7 = "item7";
        public static final String COLUMN_NAME_item8 = "item8";
        public static final String COLUMN_NAME_item9 = "item9";
        public static final String COLUMN_NAME_item10 = "item10";
        public static final String COLUMN_NAME_item11 = "item11";
        public static final String COLUMN_NAME_item12 = "item12";
        public static final String COLUMN_NAME_item13 = "item13";
        public static final String COLUMN_NAME_item14 = "item14";
        public static final String COLUMN_NAME_item15 = "item15";
    }
    public static final String CREATE_REMOCAO_ITEM =
            "CREATE TABLE " +" IF NOT EXISTS "+ RemocaoItemEntry.TABLE_NAME +" (" +
                    RemocaoItemEntry._ID + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_chave + INTEGER_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_tipo + TEXT_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_item1 + TEXT_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_item2 + TEXT_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_item3 + TEXT_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_item4 + TEXT_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_item5 + TEXT_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_item6 + TEXT_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_item7 + TEXT_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_item8 + TEXT_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_item9 + TEXT_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_item10 + TEXT_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_item11 + TEXT_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_item12 + TEXT_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_item13 + TEXT_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_item14 + TEXT_TYPE + COMMA_SEP +
                    RemocaoItemEntry.COLUMN_NAME_item15 + TEXT_TYPE +
                    ") ";

    public static class TipoRemocaoEntry implements BaseColumns {
        public static final String TABLE_NAME = "tipo_remocao";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_tipo = "tipo";
        public static final String COLUMN_NAME_grupo = "grupo";
        public static final String COLUMN_NAME_descricao = "descricao";
        public static final String COLUMN_NAME_item1 = "item1";
        public static final String COLUMN_NAME_item2 = "item2";
        public static final String COLUMN_NAME_item3 = "item3";
        public static final String COLUMN_NAME_item4 = "item4";
        public static final String COLUMN_NAME_item5 = "item5";
        public static final String COLUMN_NAME_item6 = "item6";
        public static final String COLUMN_NAME_item7 = "item7";
        public static final String COLUMN_NAME_item8 = "item8";
        public static final String COLUMN_NAME_item9 = "item9";
        public static final String COLUMN_NAME_item10 = "item10";
        public static final String COLUMN_NAME_item11 = "item11";
        public static final String COLUMN_NAME_item12 = "item12";
        public static final String COLUMN_NAME_item13 = "item13";
        public static final String COLUMN_NAME_item14 = "item14";
        public static final String COLUMN_NAME_item15 = "item15";
    }

    public static final String CREATE_TIPO_REMOCAO =
            "CREATE TABLE " +" IF NOT EXISTS "+ TipoRemocaoEntry.TABLE_NAME +" (" +
                    TipoRemocaoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_tipo + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_grupo + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_descricao + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_item1 + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_item2 + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_item3 + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_item4 + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_item5 + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_item6 + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_item7 + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_item8 + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_item9 + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_item10 + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_item11 + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_item12 + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_item13 + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_item14 + TEXT_TYPE + COMMA_SEP +
                    TipoRemocaoEntry.COLUMN_NAME_item15 + TEXT_TYPE +
                    ") ";
    //final tipo remocao

    //Inicio endereco
    public static class EnderecoEntry implements BaseColumns {
        public static final String TABLE_NAME = "endereco";
        public static final String COLUMN_NAME_descricao = "descricao";
    }

    public static final String CREATE_ENDERECO =
            "CREATE TABLE " +" IF NOT EXISTS "+ EnderecoEntry.TABLE_NAME +" (" +
                    EnderecoEntry.COLUMN_NAME_descricao + TEXT_TYPE +
                    ") ";
    //final endereco

    //Inicio item vistoria
    public static class ItemVistoriaEntry implements BaseColumns {
        public static final String TABLE_NAME = "item_vistoria";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_descricao = "descricao";
    }

    public static final String CREATE_ITEM_VISTORIA =
            "CREATE TABLE " +" IF NOT EXISTS "+ ItemVistoriaEntry.TABLE_NAME +" (" +
                    ItemVistoriaEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    ItemVistoriaEntry.COLUMN_NAME_descricao + TEXT_TYPE +
                    ") ";
    //final item vistoria

    //Inicio apoio config
    public static class ApoioConfigEntry implements BaseColumns {
        public static final String TABLE_NAME = "apoio_config";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_chave = "chave";
        public static final String COLUMN_NAME_valor = "valor";
        public static final String COLUMN_NAME_descricao = "descricao";
        public static final String COLUMN_NAME_ativo = "ativo";
    }

    public static final String CREATE_APOIO_CONFIG =
            "CREATE TABLE " +" IF NOT EXISTS "+ ApoioConfigEntry.TABLE_NAME +" (" +
                    ApoioConfigEntry.COLUMN_NAME_codigo + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
                    ApoioConfigEntry.COLUMN_NAME_chave + TEXT_TYPE + COMMA_SEP +
                    ApoioConfigEntry.COLUMN_NAME_valor + TEXT_TYPE + COMMA_SEP +
                    ApoioConfigEntry.COLUMN_NAME_descricao + TEXT_TYPE + COMMA_SEP +
                    ApoioConfigEntry.COLUMN_NAME_ativo + TEXT_TYPE +
                    ") ";
    //final apoio config

    //inicio tipo afericao
    public static class TipoAfericaoEntry implements BaseColumns {
        public static final String TABLE_NAME = "tipo_afericao";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_descricao = "descricao";
    }

    public static final String CREATE_TIPO_AFERICAO =
            "CREATE TABLE IF NOT EXISTS " + TipoAfericaoEntry.TABLE_NAME + " (" +
                    TipoAfericaoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    TipoAfericaoEntry.COLUMN_NAME_descricao + TEXT_TYPE +
                    " )";
    //final tipo afericao


    //inicio lista veiculos
    public static class ListaEntry implements BaseColumns {
        public static final String TABLE_NAME = "lista";
        public static final String COLUMN_NAME_latitude = "latitude";
        public static final String COLUMN_NAME_longitude = "longitude";
        public static final String COLUMN_NAME_placa = "placa";
        public static final String COLUMN_NAME_marca = "marca";
        public static final String COLUMN_NAME_especie = "especie";
        public static final String COLUMN_NAME_cor = "cor";
        public static final String COLUMN_NAME_uf_veiculo = "uf_veiculo";
        public static final String COLUMN_NAME_municipio_veiculo = "municipio_veiculo";
        public static final String COLUMN_NAME_debitos = "debitos";
        public static final String COLUMN_NAME_ultimo = "ultimo";
        public static final String COLUMN_NAME_restricao = "restricao";
        public static final String COLUMN_NAME_condicao = "condicao";
        public static final String COLUMN_NAME_cpf_condutor = "cpf";
        public static final String COLUMN_NAME_tipo_documento = "tipo_documento";
        public static final String COLUMN_NAME_numero_documento = "numero_documento";
        public static final String COLUMN_NAME_nome_condutor = "nome_condutor";
        public static final String COLUMN_NAME_cnh = "cnh";
        public static final String COLUMN_NAME_uf_condutor = "uf_condutor";
        public static final String COLUMN_NAME_categoria = "categoria";
        public static final String COLUMN_NAME_validade = "validade";
        public static final String COLUMN_NAME_uf_infracao = "uf_infracao";
        public static final String COLUMN_NAME_codigo_municipio = "codigo_municipio";
        public static final String COLUMN_NAME_nome_municipio = "nome_municipio";
        public static final String COLUMN_NAME_local_infracao = "local_infracao";
        public static final String COLUMN_NAME_tipo_local = "tipo_local";
        public static final String COLUMN_NAME_ponto_referencia = "ponto_referencia";
        public static final String COLUMN_NAME_bairro = "bairro";
        public static final String COLUMN_NAME_bairro_outro = "bairro_outro";
        public static final String COLUMN_NAME_data_infracao = "data_infracao";
        public static final String COLUMN_NAME_hora_infracao = "hora_infracao";
        public static final String COLUMN_NAME_recolher_cnh = "recolher_cnh";
        public static final String COLUMN_NAME_apreender_veiculo = "apreender_veiculo";
        public static final String COLUMN_NAME_recolher_cla = "recolher_cla";
        public static final String COLUMN_NAME_via_urbana = "via_urbana";
        public static final String COLUMN_NAME_rodovia = "rodovia";
        public static final String COLUMN_NAME_afericao = "afericao";
        public static final String COLUMN_NAME_equipamento = "equipamento";
        public static final String COLUMN_NAME_numero_equipamento = "numero_equipamento";
        public static final String COLUMN_NAME_modelo_equipamento = "modelo_equipamento";
        public static final String COLUMN_NAME_marca_equipamento = "marca_equipamento";
        public static final String COLUMN_NAME_medicao_realizada = "medicao_realizada";
        public static final String COLUMN_NAME_medicao_considerada = "medicao_considerada";
        public static final String COLUMN_NAME_limite_regulamentado = "limite_regulamentado";
        public static final String COLUMN_NAME_tipo_medicao = "tipo_medicao";
        public static final String COLUMN_NAME_observacoes = "observacoes";
    }

    public static final String CREATE_LISTA =
            "CREATE TABLE IF NOT EXISTS " + ListaEntry.TABLE_NAME + " (" +
                    ListaEntry._ID + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_latitude + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_longitude + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_placa + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_marca + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_especie + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_cor + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_uf_veiculo + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_municipio_veiculo + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_debitos + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_ultimo + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_restricao + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_condicao + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_cpf_condutor + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_tipo_documento + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_numero_documento + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_nome_condutor + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_cnh + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_uf_condutor + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_categoria + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_validade + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_uf_infracao + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_codigo_municipio + INTEGER_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_nome_municipio + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_local_infracao + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_tipo_local + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_ponto_referencia + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_bairro + INTEGER_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_bairro_outro + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_data_infracao + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_hora_infracao + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_recolher_cnh + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_apreender_veiculo + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_recolher_cla + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_rodovia + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_via_urbana + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_afericao + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_equipamento + INTEGER_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_numero_equipamento + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_modelo_equipamento + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_marca_equipamento + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_medicao_realizada + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_medicao_considerada + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_limite_regulamentado + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_tipo_medicao + INTEGER_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_observacoes + TEXT_TYPE + ")";

    public static class ListaEntryUltima implements BaseColumns {
        public static final String TABLE_NAME = "listaultima";
    }

    public static final String CREATE_LISTA_ULTIMA =
            "CREATE TABLE IF NOT EXISTS " + ListaEntryUltima.TABLE_NAME + " (" +
                    ListaEntry.COLUMN_NAME_latitude + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_longitude + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_placa + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_marca + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_especie + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_cor + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_uf_veiculo + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_municipio_veiculo + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_debitos + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_ultimo + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_restricao + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_condicao + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_cpf_condutor + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_tipo_documento + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_numero_documento + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_nome_condutor + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_cnh + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_uf_condutor + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_categoria + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_validade + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_uf_infracao + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_codigo_municipio + INTEGER_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_nome_municipio + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_local_infracao + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_tipo_local + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_ponto_referencia + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_bairro + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_bairro_outro + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_data_infracao + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_hora_infracao + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_recolher_cnh + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_apreender_veiculo + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_recolher_cla + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_rodovia + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_via_urbana + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_afericao + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_equipamento + INTEGER_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_numero_equipamento + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_modelo_equipamento + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_marca_equipamento + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_medicao_realizada + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_medicao_considerada + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_limite_regulamentado + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_tipo_medicao + INTEGER_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_observacoes + TEXT_TYPE + ")";

    public static class ListaInfracaoEntry implements BaseColumns {
        public static final String TABLE_NAME = "lista_infracoes";
        public static final String COLUMN_NAME_codigo_lista = "codigo_lista";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_digito = "digito";
    }

    public static final String CREATE_LISTAINFRACAO =
            "CREATE TABLE IF NOT EXISTS " + ListaInfracaoEntry.TABLE_NAME + " (" +
                    ListaInfracaoEntry.COLUMN_NAME_codigo_lista + INTEGER_TYPE + COMMA_SEP +
                    ListaInfracaoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    ListaInfracaoEntry.COLUMN_NAME_digito + INTEGER_TYPE + ")";

    public static class ListaInfracaoUltimaEntry implements BaseColumns {
        public static final String TABLE_NAME = "listaultima_infracoes";
    }

    public static final String CREATE_LISTAINFRACAO_ULTIMA =
            "CREATE TABLE IF NOT EXISTS " + ListaInfracaoUltimaEntry.TABLE_NAME + " (" +
                    ListaInfracaoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    ListaInfracaoEntry.COLUMN_NAME_digito + INTEGER_TYPE + ")";

    public static class ListaFotoEntry implements BaseColumns {
        public static final String TABLE_NAME = "lista_fotos";
//        public static final String COLUMN_NAME_id = "id";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_chave = "chave";
        public static final String COLUMN_NAME_tipo = "tipo";
        public static final String COLUMN_NAME_tipo_assinatura = "tipo_assinatura";
        public static final String COLUMN_NAME_origem = "origem";
        public static final String COLUMN_NAME_patch = "caminho";
        public static final String COLUMN_NAME_foto = "foto";
    }

    public static final String CREATE_LISTA_FOTO =
            "CREATE TABLE IF NOT EXISTS " + ListaFotoEntry.TABLE_NAME + " (" +
                    ListaFotoEntry._ID + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    ListaFotoEntry.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    ListaFotoEntry.COLUMN_NAME_chave + INTEGER_TYPE + COMMA_SEP +
                    ListaFotoEntry.COLUMN_NAME_tipo + INTEGER_TYPE + COMMA_SEP +
                    ListaFotoEntry.COLUMN_NAME_tipo_assinatura + TEXT_TYPE + COMMA_SEP +
                    ListaFotoEntry.COLUMN_NAME_origem + INTEGER_TYPE + COMMA_SEP +
                    ListaFotoEntry.COLUMN_NAME_patch + TEXT_TYPE + COMMA_SEP +
                    ListaFotoEntry.COLUMN_NAME_foto + IMAGE_TYPE + ")";

    public static class ListaEntryAproveita implements BaseColumns {
        public static final String TABLE_NAME = "lista_aproveita";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_coordenadas = "coordenadas";
        public static final String COLUMN_NAME_condutor = "condutor";
        public static final String COLUMN_NAME_municipio = "municipio";
        public static final String COLUMN_NAME_infracoes = "infracoes";
        public static final String COLUMN_NAME_fotos = "fotos";
    }

    public static final String CREATE_LISTA_APROVEITA =
            "CREATE TABLE IF NOT EXISTS " + ListaEntryAproveita.TABLE_NAME + " (" +
                    ListaEntryAproveita.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    ListaEntryAproveita.COLUMN_NAME_coordenadas + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_condicao + TEXT_TYPE + COMMA_SEP +
                    ListaEntryAproveita.COLUMN_NAME_condutor + TEXT_TYPE + COMMA_SEP +
                    ListaEntryAproveita.COLUMN_NAME_municipio + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_local_infracao + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_tipo_local + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_ponto_referencia + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_bairro + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_rodovia + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_via_urbana + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_afericao + TEXT_TYPE + COMMA_SEP +
                    ListaEntry.COLUMN_NAME_observacoes + TEXT_TYPE + COMMA_SEP +
                    ListaEntryAproveita.COLUMN_NAME_infracoes + TEXT_TYPE + COMMA_SEP +
                    ListaEntryAproveita.COLUMN_NAME_fotos + TEXT_TYPE +
                    ")";

    public static class ListaEntryAproveitaInfracao implements BaseColumns {
        public static final String TABLE_NAME = "lista_aproveita_infracoes";
        public static final String COLUMN_NAME_codigo = "codigo";
        public static final String COLUMN_NAME_digito = "digito";
    }

    public static final String CREATE_LISTA_APROVEITA_INFRACAO =
            "CREATE TABLE IF NOT EXISTS " + ListaEntryAproveitaInfracao.TABLE_NAME + " (" +
                    ListaEntryAproveitaInfracao.COLUMN_NAME_codigo + INTEGER_TYPE + COMMA_SEP +
                    ListaEntryAproveitaInfracao.COLUMN_NAME_digito + INTEGER_TYPE + ")";

    //fim lista veiculos

}

