/*
 * Desenvolvido por Luiz F. Viana em 29/08/18 18:16
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.helper;

import android.renderscript.ScriptIntrinsicYuvToRGB;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.Empreendimentos;

import java.util.ArrayList;
import java.util.List;

public class CriarEmpreendimentos {
    public static List<Empreendimentos> retornaEmp(){
        List<Empreendimentos> listaEmpreendimentos = new ArrayList<>();
        List<String> naoDisponivel = new ArrayList<>();

        naoDisponivel.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FmarcaRegistrada%2Fmr_residenciaisAlpha%2Fnao_ha_imoveis.jpeg?alt=media&token=0456956b-67f7-42f2-a438-206cbcc7c219");

        /*Cria os Empreendimentos e Adiciona a lista que é enviada para o Adapter*/
        //AZM COMPLETO
        List<String> floresCerrado = new ArrayList<>();
        floresCerrado.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resFloresCerrado%2F2.jpeg?alt=media&token=d1020f81-3a6f-4ba5-8d33-fe4a8d1746d6");
        floresCerrado.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resFloresCerrado%2F3.jpeg?alt=media&token=9f8977ac-fab0-4462-a581-2d8e3a441154");
        floresCerrado.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resFloresCerrado%2F4.jpeg?alt=media&token=e4edc15b-0d6e-4358-bfe3-ed5d54868a72");
        floresCerrado.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resFloresCerrado%2F5.jpeg?alt=media&token=4466c656-7bd3-4b0e-8e86-47318d8414a7");
        floresCerrado.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resFloresCerrado%2F6.jpeg?alt=media&token=93afeede-bf8c-4517-968d-cd1bfc48997f");
        Empreendimentos empreendimentos = new Empreendimentos(
                "Residencial Flores do Cerrado",
                "azm",
                "Venda: R$ 109.900,00 a partir",
                "Avaliação: R$ 128.000,00",
                R.drawable.img_flores_cerrado,
                "azm_resFloresCerrado", 1,"+34 3213-4393",
                "AZM",
                "• 44,70-49,80 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Piscina\n• Salão de Festas\n• Espaço Gourmet\n• Espaço Fitness\n• Entre outros...",
                "• Av. Edson Gallana, 210\n• Canaã", "Faixa 1,5", floresCerrado,
                -18.965741, -48.339644);
        listaEmpreendimentos.add(empreendimentos);

        List<String> tavares = new ArrayList<>();
        tavares.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resTavares%2F2.jpeg?alt=media&token=263391b5-6a4f-41bd-b99a-1995b1aad706");
        tavares.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resTavares%2F3.jpeg?alt=media&token=c80efcac-108b-4e5b-b751-a1b81be83f99");
        tavares.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resTavares%2F4.jpeg?alt=media&token=cee63ca3-5391-4ebc-803c-a9ab6e79bcf2");
        tavares.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resTavares%2F5.jpeg?alt=media&token=6d0bf84c-7b90-4e87-9925-8534ec458d3e");
        tavares.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resTavares%2F6.jpeg?alt=media&token=e6061771-8792-4395-b996-078402507070");
        empreendimentos = new Empreendimentos(
                "Residencial Tavares",
                "azm",
                "Venda: R$ 119.900,00 a partir",
                "Avaliação: R$ 128.000,00",
                R.drawable.avatar_empreendimento,
                "azm_resTavares",1,"+34 3213-4393",
                "AZM",
                "• 44,70 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Áreas de Convivência\n• Espaço Gourmet\n• Playground\n• Elevador\n• Entre outros...",
                "• Av. Tonico Resende\n• Parque Santo Antônio",  "Faixa 1,5", tavares,
                -18.945764, -48.350587 );
        listaEmpreendimentos.add(empreendimentos);

        List<String> vertentes = new ArrayList<>();
        vertentes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resVertentes%2F1.jpg?alt=media&token=5b89bb37-34b8-403e-bb47-8ad36db17d0a");
        vertentes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resVertentes%2F2.jpg?alt=media&token=df0c52a9-6006-4c89-b8e6-3888e597e8d4");
        vertentes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resVertentes%2F3.jpg?alt=media&token=828bbca1-7c06-4c87-9ff5-69129a20de1f");
        vertentes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resVertentes%2F5.jpg?alt=media&token=2385d7ce-9319-4369-8381-5653e40855ec");
        vertentes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resVertentes%2F6.jpg?alt=media&token=fc803484-92f2-4d8d-b9da-3545fb66085d");
        vertentes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resVertentes%2F7.jpg?alt=media&token=2c1bd9e7-0d53-47d1-af11-93410ee53c14");
        vertentes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resVertentes%2F8.jpg?alt=media&token=a66b4a0e-d9c3-4766-b629-a9d66a0f99bf");
        vertentes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resVertentes%2F9.jpg?alt=media&token=0ba68992-7b1f-4cff-8783-ee0723b76673");
        empreendimentos = new Empreendimentos(
                "Residencial Vertentes III",
                "azm",
                "Venda: R$ 129.900,00 a partir",
                "Avaliação: R$ 150.000,00",
                R.drawable.img_vertentes,
                "azm_resVertentes", 1,"+34 3213-4393",
                "AZM",
                "• 49,00-57,00 m²\n• 2 quartos (0-1 suite)\n• 1-2 banheiros\n• 1-2 vagas na Garagem\n• Entre outros...",
                "• Ampla Piscina Adulto/infantil\n• Amplo Salão de Festas\n• Espaço Gourmet\n• Áreas de convivência\n• Entre outros...",
                "• R. Alfredo Vieira\n• Jardim Europa", "Faixa 2",vertentes,
                -18.941298, -48.348096);
        listaEmpreendimentos.add(empreendimentos);

        List<String> vidaBoa = new ArrayList<>();
        vidaBoa.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resVidaBoa%2F1.jpg?alt=media&token=80c99f22-0ee0-4ea1-84da-6b9515887e01");
        vidaBoa.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resVidaBoa%2F2.jpg?alt=media&token=5c47b565-ac82-4fa3-952f-be4d5055f2d9");
        vidaBoa.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resVidaBoa%2F3.jpg?alt=media&token=3d3ee51a-f9e0-4fde-9dcb-30f8950515dd");
        vidaBoa.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resVidaBoa%2F4.jpg?alt=media&token=b532f2c5-9da4-4353-bf6c-f9d594b901ff");
        vidaBoa.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resVidaBoa%2F5.jpg?alt=media&token=72da6baa-7c12-49d4-83b4-90bdab63ac80");
        vidaBoa.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fazm%2Fazm_resVidaBoa%2F6.jpg?alt=media&token=2b4b7d3a-ed0a-4542-bfcf-017ffa78e7ac");
        empreendimentos = new Empreendimentos(
                "Residencial Vida Boa",
                "azm",
                "Venda: R$ 134.900,00 a partir",
                "Avaliação: R$ 190.000,00",
                R.drawable.img_vidaboa,
                "azm_resVidaBoa",1,"+34 3213-4393",
                "AZM",
                "• 56,90-61,50 m²\n• 2 quartos (0-1 suite)\n• 1-2 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• 3 elevadores\n• Monitoramento 24 horas\n• Playground\n• Áreas de convivência\n• Entre outros...",
                "• R. do Poe.\n• Jardim das Palmeiras",  "Faixa 2", vidaBoa,
                -18.948985, -48.318978);
        listaEmpreendimentos.add(empreendimentos);

        //BARI  COMPLETO
        List<String> evoraResidence = new ArrayList<>();
        evoraResidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fbari%2Fbari_evoraResidence%2F10.jpg?alt=media&token=406a538c-5904-478f-aa58-ae29272a9380");
        evoraResidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fbari%2Fbari_evoraResidence%2F11.jpg?alt=media&token=57d1dfc5-b270-45ea-9de4-d8e4b42375c0");
        evoraResidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fbari%2Fbari_evoraResidence%2F2.jpg?alt=media&token=477feb2d-0c4c-4637-95d9-aa8f8fc1d4a8");
        evoraResidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fbari%2Fbari_evoraResidence%2F3.jpg?alt=media&token=392b7c98-23d2-4901-b59a-c35b9c018819");
        evoraResidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fbari%2Fbari_evoraResidence%2F4.jpg?alt=media&token=cf0e75a4-c242-4e2b-b9ea-0716b4a2b2b8");
        evoraResidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fbari%2Fbari_evoraResidence%2F5.jpg?alt=media&token=b00e8e55-51a3-4723-b865-099507ce8069");
        evoraResidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fbari%2Fbari_evoraResidence%2F6.jpg?alt=media&token=f466f10c-bdb8-443f-b495-9684c394aadf");
        evoraResidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fbari%2Fbari_evoraResidence%2F7.jpg?alt=media&token=4e943351-84a0-454f-9089-00dae3eafc56");
        evoraResidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fbari%2Fbari_evoraResidence%2F8.jpg?alt=media&token=ad680e5e-bf81-4053-b991-684d1b2f7a55");
        evoraResidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fbari%2Fbari_evoraResidence%2F9.jpg?alt=media&token=c6ab0385-2d56-4b18-a5e3-6b40e481077a");
        empreendimentos = new Empreendimentos(
                "Evora Residence",
                "bari",
                "Venda: R$ 310.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_evora,
                "bari_evoraResidence",0, "+34 3229-6026",
                "BARI",
                "• 88,96-90,56 m²\n• 3 quartos (1 suite)\n• 2 banheiros\n• 2 vagas na Garagem\n• Entre outros...",
                "• 2 elevadores\n• Salão de festas com terraço\n• Brinquedoteca\n• Espaço para bicicletário\n• Entre outros...",
                "• R. Professora Maria Alves Castilho, 9640\n• Santa Mônica",  "Acima",
                evoraResidence, -18.923276, -48.233178);
        listaEmpreendimentos.add(empreendimentos);

        //C&A COMPLETO

        empreendimentos = new Empreendimentos(
                "Jardins Residence",
                "cea",
                "Venda: R$ 127.990,00",
                "Avaliação: R$ 128.000,00",
                R.drawable.avatar_empreendimento,
                "cea_jardinsRes",0, "+34 3236-1551",
                "C&A",
                "• 47,00 m²\n• 2 quartos (1 suite)\n• 2 banheiros\n• 1-2 vagas na Garagem\n• Entre outros...",
                "• Elevador\n• Portaria\n• Areas de conveniência\n• Entre outros...",
                "• R. do Calistemon, 363\n• Jardim Célia",
                 "Faixa 1,5", naoDisponivel,-18.936320, -48.377321);
        listaEmpreendimentos.add(empreendimentos);


        empreendimentos = new Empreendimentos(
                "Estoril Residence",
                "cea",
                "Venda: R$ 142.990,00",
                "Avaliação: R$ 165.000,00",
                R.drawable.avatar_empreendimento,
                "cea_estorilRes",0, "+34 3236-1551",
                "C&A",
                "• 51,00 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Elevador\n• Área de lazer \n• Espaço Gourmet\n• Azulejos até o teto (cozinha, banheiro)\n• Entre outros...",
                "• R. Leonardo da Vinci\n• Laranjeiras",
                 "Faixa 2", naoDisponivel , -18.965689, -48.247368);
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Zenith Residence",
                "cea",
                "Venda: R$ 142.990,00",
                "Avaliação: R$ 165.000,00",
                R.drawable.avatar_empreendimento,
                "cea_zenithRes",0,"+34 3236-1551",
                "C&A",
                "• A partir de 50,00 m²\n• 2 quartos (0-1 suite)\n• 1-2 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• 02 Elevadores\n• Portaria\n• Gás canalizado\n• Esquadrias de alumínio\n• Entre outros...",
                "• R. Zenith, 109\n• Jardim Brasília",
                "Faixa 2", naoDisponivel, -18.8930038, -48.3000398);
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Solaris",
                "cea",
                "Venda: R$ 149.990,00",
                "Avaliação: R$ 180.000,00",
                R.drawable.avatar_empreendimento,
                "cea_resSolaris",0, "+34 3236-1551",
                "C&A",
                "• 51,00 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Elevador\n• Portaria\n• Esquadrias em alumínio\n• Azulejo até o teto (Cozinha, banheiro e área de serviço)\n• Entre outros...",
                "• Av. Dimas Machado, 580\n• Chácaras Tubalina",
                "Faixa 2", naoDisponivel, -18.935183, -48.320994);
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Vila Real",
                "cea",
                "Venda: R$ 184.990,00",
                "Avaliação: R$ 185.000,00",
                R.drawable.avatar_empreendimento,
                "cea_resVilaReal",0,"+34 3236-1551",
                "C&A",
                "• 65,73 m²\n• 2 quartos\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Murado nas laterais e ao fundo\n• Casas individuais\n• Sala de jantar e TV integradas\n• Excelente padrão de acabamento\n• Entre outros...",
                "• Bairro Mansour II",
                "Faixa 2", naoDisponivel, -18.936320, -48.377321);
        listaEmpreendimentos.add(empreendimentos);

        List<String> plazaNorte = new ArrayList<>();
        plazaNorte.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcea%2Fcea_plazaNorteResidence%2F1.jpeg?alt=media&token=38db7d1e-c526-421c-a04b-0c94d8968345");
        plazaNorte.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcea%2Fcea_plazaNorteResidence%2F2.jpeg?alt=media&token=7480925d-f614-4992-9c3c-859d6f2f565f");
        plazaNorte.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcea%2Fcea_plazaNorteResidence%2F4.jpeg?alt=media&token=b5f63fff-536d-46cf-a9d5-dc9abbb05694");
        plazaNorte.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcea%2Fcea_plazaNorteResidence%2F5.jpeg?alt=media&token=843b0c67-8068-4e40-aed1-5efab40768e4");
        plazaNorte.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcea%2Fcea_plazaNorteResidence%2F6.jpeg?alt=media&token=4c307ddc-cc99-405d-8f00-d3b29f6f315f");
        empreendimentos = new Empreendimentos(
                "Plaza Norte Residence",
                "cea",
                "Venda: R$ 189.990,00 a partir",
                "Avaliação: R$ 190.000,00 a partir",
                R.drawable.avatar_empreendimento,
                "cea_plazaNorteResidence",0, "+34 3236-1551",
                "C&A",
                "• 56,00-67,00 m²\n• 2-3 quartos (0-1-2 suite)\n• 2 banheiros\n• 1-2 vagas na Garagem\n• Entre outros...",
                "• 2 Elevadores\n• Espaço de lazer infantil\n• Gás canalizado\n• Portaria\n• Entre outros...",
                "• Av. Adriano Bailoni, 420\n• Roosevelt",
                "Faixa 2", plazaNorte, -18.8974186, -48.2784520);
        listaEmpreendimentos.add(empreendimentos);

        List<String> monsenhor = new ArrayList<>();
        monsenhor.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcea%2Fcea_resMonsenhor%2F2.jpeg?alt=media&token=9b080087-ca68-4e6c-a9ff-96ee15f9b1cd");
        monsenhor.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcea%2Fcea_resMonsenhor%2F3.jpeg?alt=media&token=8b12a917-e740-467f-a1a7-18cb37842d1e");
        monsenhor.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcea%2Fcea_resMonsenhor%2F4.jpeg?alt=media&token=9f83c752-dd6f-446a-ab4c-23eb457d48f0");
        monsenhor.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcea%2Fcea_resMonsenhor%2F5.jpeg?alt=media&token=d5ec0a89-7d7d-4f91-810a-152567c77d13");
        monsenhor.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcea%2Fcea_resMonsenhor%2F5.jpeg?alt=media&token=d5ec0a89-7d7d-4f91-810a-152567c77d13");
        monsenhor.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcea%2Fcea_resMonsenhor%2F7.jpeg?alt=media&token=5ac3247d-10de-42db-9c72-e0ae9f8e7299");
        monsenhor.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcea%2Fcea_resMonsenhor%2F8.jpeg?alt=media&token=35a8d65d-1f51-49a8-b95e-5acb0774677c");
        monsenhor.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcea%2Fcea_resMonsenhor%2F8.jpeg?alt=media&token=35a8d65d-1f51-49a8-b95e-5acb0774677c");
        empreendimentos = new Empreendimentos(
                "Residencial Monsenhor",
                "cea",
                "Venda: R$ 195.990,00",
                "Avaliação: R$ 190.000,00",
                R.drawable.img_monsenhor,
                "cea_resMonsenhor",0, "+34 3236-1551",
                "C&A",
                "• 2 quartos (1 suite)\n• 2 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• 2 Elevadores\n• Portaria\n• Gás canalizado\n• Sacada com blindex\n• Entre outros...",
                "• R. Osório José da Cunha, 1795\n• Marta Helena",
                "Faixa 2", monsenhor, -18.936320, -48.377321);
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Queens Residence",
                "cea",
                "Venda: R$ 198.990,00",
                "Avaliação: R$ 210.000,00",
                R.drawable.avatar_empreendimento,
                "cea_queensRes", 0, "+34 3236-1551",
                "C&A",
                "• 52,37 ou 64,81 m²\n• 2 ou 3 quartos (0-1 suite)\n• 1 ou 2 banheiros\n• 2 vagas na Garagem\n• Entre outros...",
                "• 2 elevadores\n• Espaço de convivência\n• Gás canalizado\n• Portaria\n• Entre outros...",
                "• R. Dr. Luiz Antônio Waack, 1480\n• Umuarama",
                "Acima", naoDisponivel,-18.882544, -48.255123);
        listaEmpreendimentos.add(empreendimentos);

        //CIMA COMPLETO

        List<String> versatoRes = new ArrayList<>();
        versatoRes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcima%2Fcima_versatoRes%2F1.jpeg?alt=media&token=803e00e8-3d17-47bb-967e-51341926f667");
        versatoRes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcima%2Fcima_versatoRes%2F2.jpeg?alt=media&token=0ba8e6e8-7a02-439f-a474-7ec513e0ca4d");
        versatoRes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcima%2Fcima_versatoRes%2F3.jpeg?alt=media&token=a8be3f44-7d7c-4ab7-b053-0b4e32fdd265");
        versatoRes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcima%2Fcima_versatoRes%2F4.jpeg?alt=media&token=760a7139-e969-44b9-9e43-89ef54688cbc");
        versatoRes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcima%2Fcima_versatoRes%2F5.jpeg?alt=media&token=3791d8d8-6f17-473d-a0ce-9988015ef1c4");
        versatoRes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcima%2Fcima_versatoRes%2F6.jpeg?alt=media&token=2946f9cb-4bd7-4aab-b94d-8f7e761f563c");
        versatoRes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcima%2Fcima_versatoRes%2F7.jpeg?alt=media&token=8629880f-8393-4331-9396-aed75d91b243");
        versatoRes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcima%2Fcima_versatoRes%2F8.jpeg?alt=media&token=6dabda6b-166c-4207-b5ec-51ef33863de9");
        versatoRes.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fcima%2Fcima_versatoRes%2F9.jpeg?alt=media&token=86eb81c0-554e-464d-b4c7-0703c1915e15");
        empreendimentos = new Empreendimentos(
                "Versato Residence",
                "cima",
                "Venda: R$ 307.382,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_versato_res,
                "cima_versatoRes",0, "+34 3303-1900",
                "CIMA",
                "• 66 e 87 m²\n• 2 a 3 quartos (1 suite)\n• 2 vagas na Garagem\n• Entre outros...",
                "• Salão de Festas\n• Piscina\n• Espaço Gourmet com Churrasqueira\n• Quadra Poliesportiva\n• Entre outros...",
                "-",
                "Acima", versatoRes, -18.908935, -48.250678);
        listaEmpreendimentos.add(empreendimentos);

        //CONEL COMPLETO

        List<String> acquaTorre = new ArrayList<>();
        acquaTorre.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_acquaTorre%2F1.jpeg?alt=media&token=e30ba6aa-6af8-4a5b-ae3d-2e79ac13cf51");
        acquaTorre.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_acquaTorre%2F2.jpeg?alt=media&token=dd037f6d-abbc-4074-a4cd-4d65b9205fe9");
        acquaTorre.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_acquaTorre%2F3.jpeg?alt=media&token=4c60dfa1-eb4b-4597-9463-624db0b4c685");
        acquaTorre.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_acquaTorre%2F4.jpeg?alt=media&token=13ab1c37-ee3b-4376-a92f-6a159096f829");
        acquaTorre.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_acquaTorre%2F5.jpeg?alt=media&token=f519deff-d47c-4f6e-9c36-52c5b962b5a8");
        acquaTorre.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_acquaTorre%2F6.jpeg?alt=media&token=11b0f097-eef6-451f-9810-7409d6e23401");
        acquaTorre.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_acquaTorre%2F7.jpeg?alt=media&token=a5aa187e-2bae-475d-8cb8-2aa9ca0c9867");
        acquaTorre.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_acquaTorre%2F8.jpeg?alt=media&token=388657bc-741b-4353-86fb-bd08b6d80da7");
        empreendimentos = new Empreendimentos(
                "Acqua Torre Centro Sul",
                "conel",
                "Venda: R$ 271.265,92 a partir",
                "Avaliação: R$ 270.891,28 a partir",
                R.drawable.img_acquatorre,
                "conel_acquaTorre",0, "+34 3236-8600",
                "CONEL",
                "• 2-3 quartos (1-2 suite)\n• 2 banheiros\n• Entre outros...",
                "• Pontos para ar-condicionado\n• 2 Elevadores\n• Piso porcelanato\n• Playground\n• Entre outros...",
                "-",
                "Acima", acquaTorre, -18.928847, -48.292604);
        listaEmpreendimentos.add(empreendimentos);

        List<String> granPlaza = new ArrayList<>();
        granPlaza.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_granPlazaRes%2F2.jpeg?alt=media&token=637c9703-ee0b-4c88-9d58-949b69e5e9e8");
        granPlaza.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_granPlazaRes%2F2.jpeg?alt=media&token=637c9703-ee0b-4c88-9d58-949b69e5e9e8");
        granPlaza.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_granPlazaRes%2F4.jpeg?alt=media&token=9bf23546-780f-416d-8e91-e662f1d7aa9f");
        granPlaza.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_granPlazaRes%2F5.jpeg?alt=media&token=607ce704-d6c7-4cea-b3e6-946496e0b273");
        granPlaza.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_granPlazaRes%2F6.jpeg?alt=media&token=dc0e483c-6ac7-4a36-9e63-6525d1732b65");
        granPlaza.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_granPlazaRes%2F7.jpeg?alt=media&token=71b4059c-13c2-458a-8ea3-7f775896f439");
        empreendimentos = new Empreendimentos(
                "Gran Plaza Residence",
                "conel",
                "Venda: R$ 284.628,00 a partir",
                "Avaliação: R$ 284.628,00 a partir",
                R.drawable.img_granplaza,
                "conel_granPlazaRes",0,"+34 3236-8600",
                "CONEL",
                "• 45,69-73,20 m²\n• 1 ou 2 quartos (0 ou 1 suite)\n• 1 banheiro\n• 1 ou 2 vagas na Garagem\n• Entre outros...",
                "• 2 elevadores\n• Sala de ginástica\n• Salão de festas\n• Guarita\n• Entre outros...",
                "• R. Barão de Camargos, 296\n• Centro",
                "Acima", granPlaza, -18.923641, -48.278165);
        listaEmpreendimentos.add(empreendimentos);

        List<String> barao177 = new ArrayList<>();
        barao177.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_barao177%2F11.jpeg?alt=media&token=acd05a95-bbc2-43d0-8638-c3608139aa92");
        barao177.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_barao177%2F2.jpeg?alt=media&token=7837bb17-50d7-4ee5-adeb-6082b66393df");
        barao177.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_barao177%2F3.jpeg?alt=media&token=31b5d3dc-8105-4878-996c-27d1aa478011");
        barao177.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_barao177%2F4.jpeg?alt=media&token=15655a82-65f0-44c8-826b-7607e18fe2d8");
        barao177.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_barao177%2F5.jpeg?alt=media&token=ebeb47fa-7b80-45cc-a359-0658644f4e48");
        barao177.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_barao177%2F5.jpeg?alt=media&token=ebeb47fa-7b80-45cc-a359-0658644f4e48");
        barao177.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_barao177%2F7.jpeg?alt=media&token=a8dc0b57-3eea-432b-925b-3455eda24dfe");
        barao177.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_barao177%2F8.jpeg?alt=media&token=fe8c6608-36db-4e37-b0c0-2513b4c46bec");
        barao177.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_barao177%2F9.jpeg?alt=media&token=0643b231-75f6-4344-a5ba-2caf19b98df8");
        empreendimentos = new Empreendimentos(
                "Barão 177",
                "conel",
                "Venda: R$ 299.627,38 a partir",
                "Avaliação: R$ 299.213,57 a partir",
                R.drawable.img_barao177,
                "conel_barao177",0,"+34 3236-8600",
                "CONEL",
                "• 69,85-77,46 m²\n• 2 quartos (2 suites)\n• 2 banheiros\n• 1 ou 2 vagas na Garagem\n• Entre outros...",
                "• 2 Elevadores\n• Playground\n• Salão de festas\n• Espaço gourmet com churrasqueira\n• Entre outros...",
                "• R. Barão de Camargos, 177\n• Centro",
                "Acima", barao177, -18.923511, -48.277237);
        listaEmpreendimentos.add(empreendimentos);

        List<String> california = new ArrayList<>();
        california.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_edificioCalifor%2F10.jpeg?alt=media&token=4aea45dd-23f1-420f-a2b2-d40376a484b2");
        california.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_edificioCalifor%2F12.jpeg?alt=media&token=e0755e4c-f347-46b5-9b2e-5c3be6518653");
        california.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_edificioCalifor%2F13.jpeg?alt=media&token=da0f420f-ed83-48ef-88c3-270511fa9e8a");
        california.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_edificioCalifor%2F13.jpeg?alt=media&token=da0f420f-ed83-48ef-88c3-270511fa9e8a");
        california.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_edificioCalifor%2F3.jpeg?alt=media&token=098cce70-b9cd-43f1-83c0-320d1b30bc3c");
        california.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_edificioCalifor%2F4.jpeg?alt=media&token=43ced909-f2c1-4ef5-b8b5-b0b7fc790e29");
        california.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_edificioCalifor%2F8.jpeg?alt=media&token=88e5c2eb-5d1f-42f6-a3c6-b9ccf512a346");
        california.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_edificioCalifor%2F9.jpeg?alt=media&token=2e18d9a0-40ff-408a-8439-756e6e555e4c");
        empreendimentos = new Empreendimentos(
                "Edifício Califórnia",
                "conel",
                "Venda: R$ 328.629,35 a partir",
                "Avaliação: R$ 328.000,00 a partir",
                R.drawable.img_edifcalifornia,
                "conel_edificioCalifor",0,"+34 3236-8600",
                "CONEL",
                "• 86,39 m²\n• 3 quartos (1 suite)\n• 2 banheiros\n• 1 ou 2 vagas na Garagem\n• Entre outros...",
                "• 2 Elevadores\n• Salão de festas\n• Playground\n• Quiosque com churrasqueira\n• Entre outros...",
                "• R. da Carioca, 1350\n• Morada da Colina", "Acima", california,
                -18.941665, -48.285403);
        listaEmpreendimentos.add(empreendimentos);

        List<String> lidicePremium = new ArrayList<>();
        lidicePremium.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_lidicePremium%2F1.jpeg?alt=media&token=cb7c94f8-f0bf-4888-a866-f7f6114b15d4");
        lidicePremium.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_lidicePremium%2F2.jpeg?alt=media&token=7d2242a9-4015-435e-b537-172a80b64831");
        lidicePremium.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_lidicePremium%2F3.jpeg?alt=media&token=5dde8ed4-f18b-469d-8031-3aed25dbefbd");
        lidicePremium.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_lidicePremium%2F4.jpeg?alt=media&token=710e8d0b-e239-416d-aaff-406ff3a648bd");
        lidicePremium.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_lidicePremium%2F5.jpeg?alt=media&token=1c75cc3f-a5da-457f-a3f8-f5becc44956b");
        lidicePremium.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_lidicePremium%2F6.jpeg?alt=media&token=16f9897b-c1c4-472a-be64-5bf105168887");
        lidicePremium.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_lidicePremium%2F7.jpeg?alt=media&token=23e15412-6d0b-4beb-aa76-a68768e3e9bb");
        lidicePremium.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_lidicePremium%2F8.jpeg?alt=media&token=6ccaf97a-cf81-4860-a707-38f872087d41");
        lidicePremium.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fconel%2Fconel_lidicePremium%2F9.jpeg?alt=media&token=c57b1dbf-7703-4e6e-92cc-fca6757154ec");
        empreendimentos = new Empreendimentos(
                "Lídice Premium",
                "conel",
                "Venda: R$1.016.836,38 a partir",
                "Avaliação: R$1.016.863,88 a partir",
                R.drawable.avatar_empreendimento,
                "conel_lidicePremium",0,"+34 3236-8600",
                "CONEL",
                "• 166,36-342,60 m²\n• 3 quartos (3 suite)\n• 5 banheiros\n• 3 vagas na Garagem\n• Entre outros...",
                "• Piscina\n• Playground infantil\n• 2 Elevadores\n• Salão de festas\n• Entre outros...",
                "• R. Tobias Inacio\n• Lídice", "Acima", lidicePremium, -18.926833, -48.278707);
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Varandas Tapuirama",
                "conel",
                "Venda: R$ 1.022.625,81 a partir",
                "Avaliação: R$ 1.021.210,41 a partir",
                R.drawable.avatar_empreendimento,
                "conel_varandasTapui",0,"+34 3236-8600",
                "CONEL",
                "• 197,00 m²\n• 3 quartos (3 suite)\n• 4 banheiros\n• 3 vagas na Garagem\n• Entre outros...",
                "• 2 Elevadores\n• Salão de festas\n• Espaços para ginástica\n• Espaços para brinquedotecas\n• Entre outros...",
                "• R. Tapuirama, 300\n• Osvaldo Resende",
                "Acima", naoDisponivel, -18.921502, -48.289379);
        listaEmpreendimentos.add(empreendimentos);

        //HLTS
        List<String> jardimHolanda = new ArrayList<>();
        jardimHolanda.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_resJardimHol%2F11.jpg?alt=media&token=4c9f59ab-f6f9-4c3d-bb62-7b3ef5b3a61c");
        jardimHolanda.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_resJardimHol%2F12.jpg?alt=media&token=3e4bc9b6-2759-4dac-8592-b4dcff7d88a8");
        jardimHolanda.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_resJardimHol%2F2.jpg?alt=media&token=fda0fef8-1863-4368-94a4-07d1302c1849");
        jardimHolanda.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_resJardimHol%2F3.jpg?alt=media&token=9fb39adc-b4fc-46aa-b06f-24e0bcb90bd9");
        jardimHolanda.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_resJardimHol%2F3.jpg?alt=media&token=9fb39adc-b4fc-46aa-b06f-24e0bcb90bd9");
        jardimHolanda.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_resJardimHol%2F3.jpg?alt=media&token=9fb39adc-b4fc-46aa-b06f-24e0bcb90bd9");
        jardimHolanda.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_resJardimHol%2F9.jpg?alt=media&token=ea8fb974-dc00-4fff-8101-f903b5dc2050");
        empreendimentos = new Empreendimentos(
                "Residencial Jardim Holanda",
                "hlts",
                "Venda: R$ 113.000,00 a partir",
                "Avaliação: R$ 128.000,00 a partir",
                R.drawable.avatar_empreendimento,
                "hlts_resJardimHol",0,"+34 3223-5966",
                "HLTS",
                "• 2 quartos (0 suite)\n• 1 banheiro\n• 1 vagas na Garagem\n• Entre outros...",
                "-",
                "Rua Alameda José de Oliveira Guimarães - Jardim Holanda",
                "Faixa 1,5", jardimHolanda, -18.956365, -48.317597);
        listaEmpreendimentos.add(empreendimentos);

        List<String> placeAlto = new ArrayList<>();
        placeAlto.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_placeAltoUmu%2F10.jpg?alt=media&token=1de5ddb4-2c11-43fb-b08f-056bb3bd2374");
        placeAlto.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_placeAltoUmu%2F12.jpg?alt=media&token=ec0b2114-bf02-4ae1-a631-3a1d86ac54ee");
        placeAlto.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_placeAltoUmu%2F2.jpg?alt=media&token=e7ed2d77-8aac-4c30-9077-0edd02050f63");
        placeAlto.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_placeAltoUmu%2F3.jpg?alt=media&token=960dd9ea-43b1-426c-ac2b-9e07612f78e3");
        placeAlto.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_placeAltoUmu%2F3.jpg?alt=media&token=960dd9ea-43b1-426c-ac2b-9e07612f78e3");
        placeAlto.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_placeAltoUmu%2F8.jpg?alt=media&token=70e3e17d-debf-47b6-b9c5-535f28394a60");
        placeAlto.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_placeAltoUmu%2F9.jpg?alt=media&token=e8fc46e1-64b4-4f1b-8a07-0456566a0f34");
        empreendimentos = new Empreendimentos(
                "Place Alto Umuarama",
                "hlts",
                "Venda: R$ 115.000,00 a partir",
                "Avaliação: R$ 128.000,00 a partir",
                R.drawable.img_place,
                "hlts_placeAltoUmu",0, "+34 3223-5966",
                "HLTS",
                "• 47,31 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Informações ainda não disponíveis",
                "• Informações ainda não disponíveis", "Faixa 1,5", placeAlto,
                -18.937093, -48.215574);
        listaEmpreendimentos.add(empreendimentos);

        List<String> newQuality = new ArrayList<>();
        newQuality.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_newQualityRes%2F10.jpg?alt=media&token=3c516857-3d96-4fa4-a942-133496d245ee");
        newQuality.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_newQualityRes%2F11.jpg?alt=media&token=15f34705-d312-4215-be06-e4e4c2ae40e1");
        newQuality.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_newQualityRes%2F2.jpg?alt=media&token=bcd2b2df-3dde-4900-a3c4-178f601abeef");
        newQuality.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_newQualityRes%2F5.jpg?alt=media&token=6cbce1fa-010a-4b4c-acb6-44c38443d49d");
        newQuality.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_newQualityRes%2F6.jpg?alt=media&token=4e35aa1d-502c-49da-96ef-1b9b6fbe2a55");
        newQuality.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_newQualityRes%2F8.jpg?alt=media&token=249347b1-8eeb-45b1-a719-61a6251a641f");
        newQuality.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_newQualityRes%2F9.jpg?alt=media&token=ace3a0cf-5922-4219-8653-95c40088dfe1");
        empreendimentos = new Empreendimentos(
                "New Quality Residence",
                "hlts",
                "Venda: R$ 138.000,00 a partir",
                "Avaliação: R$ 180.000,00",
                R.drawable.img_newquality,
                "hlts_newQualityRes",0, "+34 3223-5966",
                "HLTS",
                "• 53,23 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Elevador\n• Piscina Infatil/Playground\n• Quadra recreativa\n• Salão de festas\n• Entre outros...",
                "• R. Renato de Oliveira Grama",
                "Faixa 2", newQuality, -18.937093, -48.251524);
        listaEmpreendimentos.add(empreendimentos);

        List<String> primeClub = new ArrayList<>();
        primeClub.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_primeClubRes%2F1.jpeg?alt=media&token=74657b9b-9db5-4a52-b53d-618b15c2c5e9");
        primeClub.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_primeClubRes%2F2.jpeg?alt=media&token=36b56eed-5345-4dd2-b574-df47fdf961bb");
        primeClub.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_primeClubRes%2F3.jpeg?alt=media&token=cf595a2d-0477-4b0b-95ae-89f42cb4423a");
        primeClub.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_primeClubRes%2F4.jpeg?alt=media&token=a4a8b673-8bfa-4060-9aa8-dee887f19ec0");
        primeClub.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_primeClubRes%2F5.jpeg?alt=media&token=10f9d9ba-4e15-4714-82e8-009200a5f5da");
        primeClub.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhlts%2Fhlts_primeClubRes%2F6.jpeg?alt=media&token=d5ca9248-dad6-4a61-97e6-19fe7eb9a297");
        empreendimentos = new Empreendimentos(
                "Prime Club Residence",
                "hlts",
                "Venda: R$ 314.300,00 a partir",
                "Avaliação: R$ 370.300,00 a partir",
                R.drawable.img_prime_club,
                "hlts_primeClubRes",0, "+34 3223-5966",
                "HLTS",
                "• 85,19 e 84,45 m²\n• 3 quartos (1 suite)\n• 2 banheiros\n• 2 vagas na Garagem\n• Entre outros...",
                "• 02 Elevadores\n• Espaço gourmet/grill\n• Piscina\n• Salão de festas\n• Entre outros...",
                "• Av. Francisco Ribeiro\n• Santa Mônica",  "Acima", primeClub,
                -18.9287291, -48.24139154);
        listaEmpreendimentos.add(empreendimentos);

        //HPR COMPLETO
        List<String> acacias = new ArrayList<>();
        acacias.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhpr%2Fhpr_resAcacias%2F1.jpg?alt=media&token=32a67d28-3c5f-47df-8eb9-926e3f6d4a3c");
        acacias.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhpr%2Fhpr_resAcacias%2F2.jpg?alt=media&token=54705248-2dd6-4b47-9bc3-5a32bea81364");
        acacias.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhpr%2Fhpr_resAcacias%2F3.jpg?alt=media&token=660bb33a-6205-4ea8-94f9-34f633272826");
        acacias.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhpr%2Fhpr_resAcacias%2F4.jpg?alt=media&token=3e13e16a-ab1c-4aa0-abe5-8a8ab7a52d31");
        acacias.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhpr%2Fhpr_resAcacias%2F5.jpg?alt=media&token=5988693d-e434-4f67-84ac-47f3990a757d");
        acacias.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhpr%2Fhpr_resAcacias%2F6.jpg?alt=media&token=1d87816c-8e57-45c3-8b22-18dec6e96374");
        acacias.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhpr%2Fhpr_resAcacias%2F7.jpg?alt=media&token=21e7c350-40b3-415c-9fa5-254622895ec9");
        acacias.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhpr%2Fhpr_resAcacias%2F8.jpg?alt=media&token=3f307fdc-e4b1-4a06-a266-d66af7633ad7");
        empreendimentos = new Empreendimentos(
                "Residencial Acácias",
                "hpr",
                "Venda: R$ 174.900,00 a partir",
                "Avaliação: R$ 190.000,00",
                R.drawable.img_acacias,
                "hpr_resAcacias",0, "+34 3229-7962",
                "HPR",
                "• 52 até 58 m²\n• 2 quartos (1 suite)\n• 2 banheiros\n• 2 vagas na Garagem\n• Entre outros...",
                "• Portaria\n• Salão de festas\n• Espaço kids\n• Área de lazer\n• Entre outros...",
                "• Av. dos Ferreiras, 175\n• Jardim Califórnia", "Faixa 2", acacias,
                -18.872044, -48.233464);
        listaEmpreendimentos.add(empreendimentos);

        List<String> araucarias = new ArrayList<>();
        araucarias.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhpr%2Fhpr_resAraucarias%2F1.jpg?alt=media&token=c202036c-23a6-44f5-bd41-065d75521950");
        araucarias.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhpr%2Fhpr_resAraucarias%2F2.jpg?alt=media&token=21ae4019-0c0d-4523-ba02-fc603a59e82b");
        araucarias.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhpr%2Fhpr_resAraucarias%2F3.jpg?alt=media&token=20188eec-13be-4fc3-95b3-81c4134a050b");
        araucarias.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhpr%2Fhpr_resAraucarias%2F4.jpg?alt=media&token=53e596d8-c8b5-4670-b20d-a821593bdd6c");
        araucarias.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhpr%2Fhpr_resAraucarias%2F5.jpg?alt=media&token=d0ff10e1-0cf5-43a4-b1c5-d2bed5ce4aa1");
        araucarias.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhpr%2Fhpr_resAraucarias%2F6.jpg?alt=media&token=36ef4f45-3753-4588-975f-d6c5075a1be8");
        araucarias.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fhpr%2Fhpr_resAraucarias%2F7.jpg?alt=media&token=28d93f92-a43c-4c3b-abd5-fcda689f5ea7");
        empreendimentos = new Empreendimentos(
                "Residencial Araucárias",
                "hpr",
                "Venda: R$ 179.900,00 a partir",
                "Avaliação: R$ 190.000,00",
                R.drawable.img_araucarias,
                "hpr_resAraucarias",0, "+34 3229-7962",
                "HPR",
                "• 52 até 56 m²\n• 2 quartos (1 suite)\n• 2 banheiros\n• 2 vagas na Garagem\n• Entre outros...",
                "• Portaria\n• Salão de festas\n• Espaço kids\n• 2 Elevadores\n• Entre outros...",
                "• R. Domingos Alvares, 79\n• Roosevelt",
                "Faixa 2", araucarias, -18.899538, -48.286909);
        listaEmpreendimentos.add(empreendimentos);

        //L Silva COMPLETO

        List<String> rubi = new ArrayList<>();
        rubi.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Flsilva%2Flsilva_rubiRes%2F2.jpeg?alt=media&token=ed90cc24-9016-42ce-ba86-bb972ac4e5b3");
        rubi.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Flsilva%2Flsilva_rubiRes%2F3.jpeg?alt=media&token=6e66d0ed-4154-4052-ba9f-40d65e72aae5");
        rubi.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Flsilva%2Flsilva_rubiRes%2F4.jpeg?alt=media&token=afb16ce0-5abe-48e0-8801-8e51b9f972c3");
        rubi.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Flsilva%2Flsilva_rubiRes%2F5.jpeg?alt=media&token=0ac385ff-e540-4edb-923c-c7047fa15ae8");
        empreendimentos = new Empreendimentos(
                "Edifício Rubi Residence",
                "lsilva",
                "Venda: R$ 220.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_rubi,
                "lsilva_rubiRes",0, "+34 3083-2950",
                "L Silva",
                "• 57,82 m²\n• 2 quartos (1 ou 2 suite)\n• 2 banheiros\n• 2 vagas na Garagem\n• Entre outros...",
                "• Elevador\n• Playground\n• Portaria\n• Espaço fitness/gourrmet\n• Entre outros...",
                "• R. Bernardo de Vasconcelos, 780\n• Pampulha", "Acima", rubi,
                -18.933670, -48.239460);
        listaEmpreendimentos.add(empreendimentos);

        //Marca Registrada COMPLETO

        empreendimentos = new Empreendimentos("Residencial Mirante 1 e 2",
                "marcaRegistrada",
                "Venda: R$110.000,00",
                "Avaliação: R$110.000,00",
                R.drawable.avatar_empreendimento,
                "mr_resMirante",0, "+34 3256-0800",
                "Marca Registrada",
                "Informações não disponíveis!",
                "Informações não disponíveis!",
                "Informações não disponíveis!",
                "Faixa 1,5", naoDisponivel, -18.975827, -48.275174);
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos("Residenciais Park",
                "marcaRegistrada",
                "Venda: R$120.000,00 a partir",
                "Avaliação: R$127.000,00",
                R.drawable.avatar_empreendimento,
                "mr_residenciaisPark",0,"+34 3256-0800",
                "Marca Registrada",
                "• 40,00 m²\n• 2 quartos (0 suite)\n• 1 banheiro\n• 1 vagas na Garagem\n• Entre outros...",
                "• Área Verde\n• Play-Ground\n• Área de Descanço\n• Entre outros...",
                "• R. Atílio Spini\n• Shopping Park",
                "Faixa 1,5", naoDisponivel, -18.9901803, -48.2672743);
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos("Residenciais Alpha",
                "marcaRegistrada",
                "Venda: R$120.000,00 a partir",
                "Avaliação: R$128.000,00",
                R.drawable.avatar_empreendimento,
                "mr_residenciaisAlpha",0,"+34 3256-0800",
                "Marca Registrada",
                "• 40,00 m²\n• 2 quartos (0 suite)\n• 1 banheiro\n• 1 vagas na Garagem\n• Entre outros...",
                "• Área Verde\n• Play-Ground\n• Área de Descanço\n• Entre outros...",
                "• R. dos Votos\n• Complexo Integração",
                "Faixa 1,5", naoDisponivel, -18.908925, -48.205216);
        listaEmpreendimentos.add(empreendimentos);

        List<String> granToro = new ArrayList<>();
        granToro.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FmarcaRegistrada%2Fmr_granToro%2F1.jpg?alt=media&token=a0de8d4f-f83e-45e5-b8e2-16a84f337bf8");
        granToro.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FmarcaRegistrada%2Fmr_granToro%2F2.jpg?alt=media&token=6858a2bc-dfd9-4ca0-a948-e26219386a8c");
        granToro.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FmarcaRegistrada%2Fmr_granToro%2F3.jpg?alt=media&token=d79101c0-157a-4c52-903a-97a06df778ae");
        granToro.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FmarcaRegistrada%2Fmr_granToro%2F4.jpg?alt=media&token=2548e2ce-e13c-499b-8044-761922fd177b");
        empreendimentos = new Empreendimentos(
                "Gran Toro",
                "marcaRegistrada",
                "Venda: R$ 131.000,00 a partir",
                "Avaliação: R$ 145.000,00 a partir",
                R.drawable.img_grantoro,
                "mr_granToro",0, "+34 3014-5001",
                "Marca Registrada",
                "• 44 ou 49 m²\n• 2 quartos (0 suite)\n• 1 banheiro\n• 1 vagas na Garagem\n• Entre outros...",
                "• Varanda Gourmet\n• 2 Elevadores\n• Espaço kids\n• Praças e canteiros com paisagismo\n• Entre outros...",
                "• R. Bétis, 305\n• Zona Sul de Uberlândia",  "Faixa 2", granToro,
                -18.9653999, -48.2482812);
        listaEmpreendimentos.add(empreendimentos);

        //MRV COMPLETO

        List<String> trilhasCerrado = new ArrayList<>();
        trilhasCerrado.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_trilhaCerrado%2F2.jpeg?alt=media&token=dfeb6317-08e5-4f69-82f7-069a74ef40e3");
        trilhasCerrado.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_trilhaCerrado%2F3.jpeg?alt=media&token=fdcf19e1-bb55-418f-bcae-cb61df1be9b7");
        trilhasCerrado.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_trilhaCerrado%2F4.jpeg?alt=media&token=d94ea3f4-09f1-4596-bd23-6b616d333615");
        trilhasCerrado.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_trilhaCerrado%2F5.jpeg?alt=media&token=f40123c6-f037-4da4-b33a-1a6c4de4a4c0");
        trilhasCerrado.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_trilhaCerrado%2F6.jpeg?alt=media&token=5d4453f7-32fa-43a7-9488-41017609310f");
        trilhasCerrado.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_trilhaCerrado%2F7.jpeg?alt=media&token=383b2749-29db-4e78-b750-749ab41235f0");
        trilhasCerrado.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_trilhaCerrado%2F8.jpeg?alt=media&token=02da755f-6b45-4f44-a083-56d87d5df5f1");
        empreendimentos = new Empreendimentos(
                "Parque Trilhas do Cerrado",
                "mrv",
                "Venda: R$ 128.000,00 a partir",
                "Avaliação: R$ 128.000,00 a partir",
                R.drawable.img_trilhas_cerrado,
                "mrv_trilhaCerrado",0, "+34 4004-9000",
                "MRV",
                "• 39,6 ou 46,46 m²\n• 2 quartos (0 suite)\n• 1 banheiro\n• 1 vagas na Garagem\n• Entre outros...",
                "• Salão de festas\n• Playground\n• Espaço gourmet\n• Piscina adulto/infantil\n• Entre outros...",
                "• Av. Manuel Lucio, 520\n• Grand Ville", "Faixa 1,5", trilhasCerrado,
                -18.9105246, -48.2170002);
        listaEmpreendimentos.add(empreendimentos);

        List<String> trilhasSabia = new ArrayList<>();
        trilhasSabia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_trilhaSabia%2F10.jpeg?alt=media&token=394458b9-8517-4c02-8bc4-783c9343b705");
        trilhasSabia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_trilhaSabia%2F2.jpeg?alt=media&token=adca6194-f518-45b6-85c2-1400c961fc99");
        trilhasSabia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_trilhaSabia%2F3.jpeg?alt=media&token=8bf4d99e-e29d-4768-bc26-2e1ebdd86b13");
        trilhasSabia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_trilhaSabia%2F4.jpeg?alt=media&token=3fa5062a-708a-4961-b64e-3fed5bd6bea1");
        trilhasSabia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_trilhaSabia%2F5.jpeg?alt=media&token=a85889ba-060c-4a29-af60-71b0e6c35a6c");
        trilhasSabia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_trilhaSabia%2F6.jpeg?alt=media&token=75835cad-3a4b-48ee-88e5-640f0924d274");
        trilhasSabia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_trilhaSabia%2F7.jpeg?alt=media&token=5b4d9a25-567c-4439-8e6f-340240969e3f");
        trilhasSabia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_trilhaSabia%2F8.jpeg?alt=media&token=08d2d70c-6d40-4dc2-bdf7-4b4e33a93fbe");
        trilhasSabia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_trilhaSabia%2F9.jpeg?alt=media&token=28b2d35b-777f-4a00-bece-726b3aefa40f");
        empreendimentos = new Empreendimentos(
                "Parque Trilhas do Sábia",
                "mrv",
                "Venda: R$ 128.000,00 a partir",
                "Avaliação: R$ 128.000,00 a partir",
                R.drawable.img_trilhas_sabia,
                "mrv_trilhaSabia",0, "+34 4004-9000",
                "MRV",
                "• 39,3 ou 46,46 m²\n• 2 quartos (0 suite)\n• 1 banheiro\n• 1 vagas na Garagem\n• Entre outros...",
                "• Salão de Festas\n• Piscina adulto/infantil\n• Quadra Gramada e Poliesportiva\n• Espaço Gourmet\n• Entre outros...",
                "• Av. dos Eucaliptos, 1140\n• Jardim Patrícia", "Faixa 1,5", trilhasSabia,
                -18.9128059, -48.3257193);
        listaEmpreendimentos.add(empreendimentos);

        List<String> unistella = new ArrayList<>();
        unistella.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_unistella%2F2.jpeg?alt=media&token=499e28df-e2e2-4d46-9089-475b0852fe01");
        unistella.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_unistella%2F3.jpeg?alt=media&token=4c91757a-adb2-4d44-bfa2-66a4f472b4f3");
        unistella.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_unistella%2F4.jpeg?alt=media&token=ed9bf3e9-fbf8-4def-97f4-1a2c877080f1");
        unistella.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_unistella%2F5.jpeg?alt=media&token=613fe760-c71e-491a-aedd-a65587afdf03");
        unistella.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_unistella%2F6.jpeg?alt=media&token=fb8962f5-cae2-4286-ad81-41e6650c0721");
        unistella.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_unistella%2F7.jpeg?alt=media&token=0aaa1936-3d4c-4c89-aaf5-c44d2997cf7d");
        unistella.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_unistella%2F9.jpeg?alt=media&token=3bb2d860-97f5-4e8d-bae8-b68e00e330d8");
        unistella.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_unistella%2F8.jpeg?alt=media&token=45a51343-ba4e-4473-a908-8fc182a6696e");
        empreendimentos = new Empreendimentos(
                "Parque Unistella",
                "mrv",
                "Venda: R$ 128.000,00 a partir",
                "Avaliação: R$ 128.000,00 a partir",
                R.drawable.img_unistella,
                "mrv_unistella",0, "+34 4004-9000",
                "MRV",
                "• 41,14 ou 46,47 m²\n• 2 quartos (0 suite)\n• 1 banheiro\n• 1 vagas na Garagem\n• Entre outros...",
                "• Salão de Festas\n• Playground\n• Espaço Gourmet\n• Piscinas Adulto e Infantil\n• Entre outros...",
                "• Rua Aguapés, 800\n•Chácaras Tubalina", "Faixa 1,5", unistella,
                -18.921933, -48.316037);
        listaEmpreendimentos.add(empreendimentos);

        List<String> hydePark = new ArrayList<>();
        hydePark.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_hydePark%2F2.jpeg?alt=media&token=4b80686a-848b-404b-97bf-e5d716fe8cb2");
        hydePark.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_hydePark%2F3.jpeg?alt=media&token=1b9aa259-0df5-4e5a-8e24-f9aa0c106e59");
        hydePark.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_hydePark%2F4.jpeg?alt=media&token=2fefff41-28ff-4331-a3f0-aa17a43cc7f7");
        hydePark.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_hydePark%2F5.jpeg?alt=media&token=8920a689-684b-4f3f-bc66-7f62fcaeacce");
        hydePark.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_hydePark%2F5.jpeg?alt=media&token=8920a689-684b-4f3f-bc66-7f62fcaeacce");
        hydePark.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_hydePark%2F7.jpeg?alt=media&token=f3a394c6-1a66-4472-b6d2-aa67c855b89f");
        hydePark.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_hydePark%2F8.jpeg?alt=media&token=a568e955-b782-475e-a44e-a1961b8ab5bf");
        empreendimentos = new Empreendimentos(
                "Resid_Hyde Park",
                "mrv",
                "Venda: R$ 128.000,00 a partir",
                "Avaliação: R$ 128.000,00 a partir",
                R.drawable.img_hyde_park,
                "mrv_hydePark",0, "+34 4004-9000",
                "MRV",
                "• 39,3 ou 46,46 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Salão de Festas\n• Playground\n• Espaço Fitness\n• Piscinas Adulto e Infantil\n• Entre outros...",
                "• Rua Dolorita Elias do Nascimento, 220\n• Região do São Jorge",
                "Faixa 1,5", hydePark,
                -18.9520644, -48.2359943);
        listaEmpreendimentos.add(empreendimentos);

        List<String> univita = new ArrayList<>();
        univita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_univita%2F10.jpeg?alt=media&token=b8abc624-7a56-4662-8094-9a4dab7ce536");
        univita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_univita%2F2.jpeg?alt=media&token=98af0720-b047-4839-8c51-6dae3a066469");
        univita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_univita%2F3.jpeg?alt=media&token=58d03e86-e022-4055-988e-250321e70801");
        univita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_univita%2F4.jpeg?alt=media&token=6b0587cf-f5c8-42c4-a4aa-6a448f02cdde");
        univita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_univita%2F5.jpeg?alt=media&token=df7828f8-3368-4dc5-809b-a53a76f9c751");
        univita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_univita%2F6.jpeg?alt=media&token=382cc7f6-69cb-4bef-bcfd-89e83422ae49");
        univita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_univita%2F7.jpeg?alt=media&token=4e12f166-b9a1-4806-99f4-b1c918f1641b");
        univita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_univita%2F7.jpeg?alt=media&token=4e12f166-b9a1-4806-99f4-b1c918f1641b");
        univita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_univita%2F9.jpeg?alt=media&token=4b936d8d-0aa8-4371-be11-ca71ea0d7ed9");
        empreendimentos = new Empreendimentos(
                "Parque Univita",
                "mrv",
                "Venda: R$ 128.000,00 a partir",
                "Avaliação: R$ 146.000,00 a partir",
                R.drawable.img_univita,
                "mrv_univita",0, "+34 4004-9000",
                "MRV",
                "• 39,3 ou 46,49 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Salão de Festas\n• Espaço Gourmet\n• Piscinas Adulto e Infantil\n• Espaço Kids\n• Entre outros...",
                "• Alameda José de Oliveira Guimarães, 900\n• Jardim Holanda",
                "Faixa 2", univita, -18.9566551,-48.3191597);
        listaEmpreendimentos.add(empreendimentos);

        List<String> unitedStates = new ArrayList();
        unitedStates.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_parqueUnitedStates%2F1.jpeg?alt=media&token=b45950ec-5b11-4b9d-8b27-0910a1437921");
        unitedStates.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_parqueUnitedStates%2F10.jpeg?alt=media&token=dddc6e31-08b8-4106-b60c-113fe287bf03");
        unitedStates.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_parqueUnitedStates%2F11.jpeg?alt=media&token=8cbce2d8-8370-4b95-914f-2d3d8bff5742");
        unitedStates.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_parqueUnitedStates%2F3.jpeg?alt=media&token=c515e4da-beef-469e-b01b-7ed1f0a87474");
        unitedStates.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_parqueUnitedStates%2F4.jpeg?alt=media&token=491c6e8c-e6c9-480a-8af9-7f49f7a42096");
        unitedStates.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_parqueUnitedStates%2F5.jpeg?alt=media&token=d49cf14e-151f-41a1-872e-bc1139ca74b4");
        unitedStates.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_parqueUnitedStates%2F6.jpeg?alt=media&token=2f9d4f00-bdca-4d9d-955a-74b5f41885c4");
        unitedStates.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_parqueUnitedStates%2F7.jpeg?alt=media&token=0bcb70b0-8c87-4e1c-bfe4-d91fce8fa609");
        unitedStates.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_parqueUnitedStates%2F8.jpeg?alt=media&token=3f89515c-68a2-46c9-8088-0aa6b1760a3f");
        unitedStates.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_parqueUnitedStates%2F9.jpeg?alt=media&token=743ff596-847d-48ef-b735-78bfc7343809");
        empreendimentos = new Empreendimentos(
                "Parque United States",
                "mrv",
                "Venda: R$ 128.000,00 a partir",
                "Avaliação: R$ 150.500,00 a partir",
                R.drawable.img_parque_states,
                "mrv_parqueUnitedStates",0, "+34 4004-9000",
                "MRV",
                "• 41,14 ou 47,7 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Salão de Festas\n• Playground\n• Quadra Poliesportiva\n• Espaço Gourmet\n• Entre outros...",
                "• R Professora Maria Célia Cence\n• Região da Gávea","Faixa 2", unitedStates,
                -18.9661300, -48.27963224);
        listaEmpreendimentos.add(empreendimentos);

        List<String> uniplace = new ArrayList();
        uniplace.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_uniplace%2F1.jpeg?alt=media&token=da903883-a033-4f1b-82b3-ee0c143d4733");
        uniplace.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_uniplace%2F2.jpeg?alt=media&token=4bd246e8-a155-4c80-a294-74a59adce943");
        uniplace.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_uniplace%2F3.jpeg?alt=media&token=9969497b-d181-44c5-8732-7d248d7e9901");
        uniplace.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_uniplace%2F3.jpeg?alt=media&token=9969497b-d181-44c5-8732-7d248d7e9901");
        uniplace.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_uniplace%2F5.jpeg?alt=media&token=8b4f220e-f631-4b6e-b4b4-a8f1267a4e94");
        uniplace.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_uniplace%2F6.jpeg?alt=media&token=5ae08be3-1851-4813-8a51-f2736ad2e1dc");
        uniplace.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_uniplace%2F7.jpeg?alt=media&token=c85cd7ec-b813-4875-bfb6-3b57b21b7379");
        empreendimentos = new Empreendimentos(
                "Spazio Uniplace",
                "mrv",
                "Venda: R$ 128.691,00 a partir",
                "Avaliação: R$ 150.000,00 a partir",
                R.drawable.avatar_empreendimento,
                "mrv_uniplace",0, "+34 4004-9000",
                "MRV",
                "• 39,39 - 49,43 m²\n• 1-2 quartos (0-1 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Salão de Festas\n• Playground\n• Espaço Gourmet\n• Piscinas Adulto e Infantil\n• Entre outros...",
                "• Av. Rodrigo Pereira Júnior, 205\n• Roosvelt","Faixa 2", uniplace,
                -18.9017808, -48.2865066);
        listaEmpreendimentos.add(empreendimentos);

        List<String> parqueUba = new ArrayList();
        parqueUba.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_uba%2F1.jpeg?alt=media&token=fe392235-2f9d-462d-8b69-141afc861b98");
        parqueUba.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_uba%2F2.jpeg?alt=media&token=a1131ade-20b8-44d6-8652-d06c7a8cae53");
        parqueUba.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_uba%2F3.jpeg?alt=media&token=2d935817-a303-4a0f-9ee7-199bf80ba4b9");
        parqueUba.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_uba%2F4.jpeg?alt=media&token=d26d48d7-9073-4dbe-b510-cc6287166acb");
        parqueUba.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_uba%2F6.jpeg?alt=media&token=49a1be8c-8454-44e7-a07c-8e08fe4bc49f");
        parqueUba.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_uba%2F7.jpeg?alt=media&token=35bed800-8baa-4957-be2d-c334eeeb54c5");
        parqueUba.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_uba%2F8.jpeg?alt=media&token=aae9f235-cc2c-4c6d-aab8-41581e78598b");
        parqueUba.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_uba%2F9.jpeg?alt=media&token=9a975b6f-d591-4448-9717-e2e299d8c2eb");
        empreendimentos = new Empreendimentos(
                "Parque Ubá",
                "mrv",
                "Venda: R$ 137.217,00",
                "Avaliação: R$ 139.000,00",
                R.drawable.img_uba,
                "mrv_uba",0, "+34 4004-9000",
                "MRV",
                "• 44,01 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Salão de Festas\n• Playgroung\n• Quadra Gramada\n• Gazebo\n• Entre outros...",
                "• Rua Luiza Naves Flack, 150\n• Região da Gávea","Faixa 2", parqueUba,
                -18.970711, -48.274580);
        listaEmpreendimentos.add(empreendimentos);

        List<String> unigarden = new ArrayList();
        unigarden.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_unigarden%2F1.jpeg?alt=media&token=516a76d3-7f86-42e8-b8ae-266cd93ccd80");
        unigarden.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_unigarden%2F3.jpeg?alt=media&token=2a77c965-aa81-4b81-8d89-bd0dc6efd4d4");
        unigarden.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_unigarden%2F4.jpeg?alt=media&token=256ce35b-d2b6-4cff-aee8-4a7720012bf2");
        unigarden.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_unigarden%2F5.jpeg?alt=media&token=40a574e3-faf1-4971-bdbc-6847f9210bbd");
        unigarden.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_unigarden%2F6.jpeg?alt=media&token=859f2151-2f80-4ac5-9cb8-a5a639fe311c");
        unigarden.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_unigarden%2F7.jpeg?alt=media&token=a3bbab66-8e7f-4966-902e-d231194560de");
        unigarden.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmrv%2Fmrv_unigarden%2F8.jpeg?alt=media&token=3843591d-cd99-472e-9bc8-780401f2bf58");
        empreendimentos = new Empreendimentos(
                "Spazio Unigarden",
                "mrv",
                "Venda: R$ 137.981 a partir",
                "Avaliação: R$ 170.000,00 a partir",
                R.drawable.img_unigarden,
                "mrv_unigarden",0, "+34 4004-9000",
                "MRV",
                "• 35,76 - 51,06 m²\n• 1-2 quartos (0-1 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Salão de Festas\n• Playground\n• Espaço Fitness\n• Piscinas Adulto e Infantil\n• Entre outros...",
                "• Av. Oscarina Cunha Chaves, 510\n• Copacabana", "Faixa 2", unigarden,
                -18.9395354, -48.2818682);
        listaEmpreendimentos.add(empreendimentos);

        //MAXI COMPLETO
        List<String> provence = new ArrayList<>();
        provence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmaxi%2Fmaxi_provenceResClub%2F1.jpg?alt=media&token=81191fcf-c1f2-46b1-8356-7f661544db97");
        provence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmaxi%2Fmaxi_provenceResClub%2F10.jpg?alt=media&token=418aaa39-7646-437b-a121-8b934ef24f49");
        provence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmaxi%2Fmaxi_provenceResClub%2F11.jpg?alt=media&token=dc1e0198-1b36-4c38-aa6c-a5e98683d62d");
        provence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmaxi%2Fmaxi_provenceResClub%2F12.jpg?alt=media&token=62f36e6d-b3cc-4037-88cd-80f9cb204fec");
        provence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmaxi%2Fmaxi_provenceResClub%2F18.jpg?alt=media&token=053c0cf2-2096-4917-9c3b-bceb7efe8ba4");
        provence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmaxi%2Fmaxi_provenceResClub%2F2.jpg?alt=media&token=86b93633-e886-465b-898a-1b056254469c");
        provence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmaxi%2Fmaxi_provenceResClub%2F3.jpg?alt=media&token=29d8eb60-64dd-45a4-98a5-af1383c1be1d");
        provence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmaxi%2Fmaxi_provenceResClub%2F4.jpg?alt=media&token=a3c6c491-075b-4392-bf42-e53a6d829aa4");
        provence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmaxi%2Fmaxi_provenceResClub%2F7.jpg?alt=media&token=f193ed1d-85a3-4e36-aaf4-1c5e86c431d9");
        provence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmaxi%2Fmaxi_provenceResClub%2F9.jpg?alt=media&token=f7bfd491-92f0-4378-a5cd-91da1161e308");
        empreendimentos = new Empreendimentos(
                "Provence Residence Club",
                "maxi",
                "Venda: R$334.700,00 a partir",
                "Avaliação: R$340.000,00 a partir",
                R.drawable.img_provence,
                "maxi_provenceResClub",0, "34 3214-4424",
                "MAXI",
                "• 74,51 ou 107,29 m²\n• 2 ou 3 quartos (1 suite)\n• 2 banheiros\n• 2 vagas na Garagem\n• Entre outros...",
                "• Piscina, spa e sauna\n• Espaço gourmet\n• Espaço fitness e kids\n• Salão de festas\n• Entre outros...",
                "• Rua José Saramago, 1497\n• Santa Mônica",
                "Acima", provence, -18.925502, -48.248975);
        listaEmpreendimentos.add(empreendimentos);

        //MOR COMPLETO
        List<String> colinaSul = new ArrayList<>();
        colinaSul.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmor%2Fmor_colinaSul%2F2.jpeg?alt=media&token=0eee2585-d4e2-4f0f-b850-d841d45fc418");
        colinaSul.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmor%2Fmor_colinaSul%2F3.jpeg?alt=media&token=466e4775-6ea8-483a-8ba7-a84f5eb436b1");
        colinaSul.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmor%2Fmor_colinaSul%2F4.jpeg?alt=media&token=3012db09-876f-4952-bc18-12129656ad13");
        colinaSul.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmor%2Fmor_colinaSul%2F5.jpeg?alt=media&token=88103cf1-2dae-4622-a639-a1337e02bb3d");
        colinaSul.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmor%2Fmor_colinaSul%2F6.jpeg?alt=media&token=f85488d7-b2d4-4bff-9f66-1c5164ae338c");
        colinaSul.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmor%2Fmor_colinaSul%2F7.jpeg?alt=media&token=7f5423f5-17e9-4e3b-8079-7f8cf502b062");
        empreendimentos = new Empreendimentos(
                "Residencial Colina Sul",
                "mor",
                "Venda: R$110.000,00",
                "Avaliação: R$120.000,00",
                R.drawable.img_colina_sul,
                "mor_colinaSul", 0, "+34 3227-7007",
                "MOR",
                "• 45 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Espaço de ginástica ao ar livre\n• Quiosque para eventos\n• Portaria \n• Depósito de lixo\n• Entre outros...",
                "• Av. Sul Americana\n• Shopping Park", "Faixa 1,5", colinaSul,
                -18.979736, -48.277298);
        listaEmpreendimentos.add(empreendimentos);

        List<String> belloSul = new ArrayList<>();
        belloSul.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmor%2Fmor_belloSul%2F2.jpeg?alt=media&token=8d8c3716-f603-4a2d-8fe3-9fdace8875b1");
        belloSul.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmor%2Fmor_belloSul%2F3.jpeg?alt=media&token=848111c5-ec88-4436-90d8-f5d335ba7619");
        belloSul.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmor%2Fmor_belloSul%2F4.jpeg?alt=media&token=7e814b98-79f5-48fe-9c73-73b38d71db46");
        belloSul.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmor%2Fmor_belloSul%2F5.jpeg?alt=media&token=b1a72456-d26b-4482-96a2-90b893d72669");
        belloSul.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmor%2Fmor_belloSul%2F6.jpeg?alt=media&token=95078754-c04a-426c-866e-074650374bde");
        belloSul.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmor%2Fmor_belloSul%2F7.jpeg?alt=media&token=8e00f5f4-6658-44fb-be35-4383c8947f10");
        belloSul.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmor%2Fmor_belloSul%2F8.jpeg?alt=media&token=7b1b8e48-b1d0-4bb1-afae-484bd41ba81e");
        belloSul.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fmor%2Fmor_belloSul%2F9.jpg?alt=media&token=42cbe40c-cb4e-4abf-b7d3-d0758ce6a817");
        empreendimentos = new Empreendimentos(
                "Residencial Bello Sul",
                "mor",
                "Venda: R$129.900,00 a partir",
                "Avaliação: R$149.000,00 a partir",
                R.drawable.img_bello_sul,
                "mor_belloSul", 1, "+34 3227-7007" ,
                "MOR",
                "• 50 m²\n• 2 quartos (1 suite)\n• 2 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Espaço Gourmet\n• Salão de festas\n• Espaço de ginástica ao ar livre\n• Piscina adulto/infantil\n• Entre outros...",
                "• Av. Sul Americana\n• Shopping Park",  "Faixa 2", belloSul,
                -18.980191, -48.279035);
        listaEmpreendimentos.add(empreendimentos);

        //Opcao COMPLETO

        List<String> platina = new ArrayList<>();
        platina.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_resPlatina%2F2.jpeg?alt=media&token=4795d5ee-e439-4beb-bb79-d1caccb98f2f");
        platina.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_resPlatina%2F3.jpeg?alt=media&token=d029b444-9bb5-423b-8728-6b2e0a4f739f");
        platina.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_resPlatina%2F4.jpeg?alt=media&token=07ac6c79-c766-4cb8-8561-da1f9d8b5be3");
        platina.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_resPlatina%2F5.jpeg?alt=media&token=153aa82e-fb4c-4dc1-8b76-4fae4b0ff7b7");
        platina.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_resPlatina%2F6.jpeg?alt=media&token=e1883be7-c53f-4292-ae89-4158140b95e7");
        platina.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_resPlatina%2F7.jpeg?alt=media&token=0c87d2f7-215c-4a50-828e-a535e7442f37");
        platina.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_resPlatina%2F8.jpeg?alt=media&token=776c4224-44bf-4c30-a800-cfe09aab05ff");
        empreendimentos = new Empreendimentos(
                "Residencial Platina",
                "opcao",
                "Venda: R$ 136.900,00 a partir",
                "Avaliação: R$ 170.000,00",
                R.drawable.img_res_platina,
                "opcao_resPlatina",0, "+34 3224-5948",
                "Opcao",
                "• A partir de 47 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Salão de festas e espaço para playground\n• Portaria projetada para funcionamento 24 h\n• Elevador\n• Gás canalizado\n• Entre outros...",
                "• Avenida Platina, 545\n• Dona Zulmira",
                "Faixa 2", platina, -18.911519, -48.311260);
        listaEmpreendimentos.add(empreendimentos);

        List<String> royale = new ArrayList<>();
        royale.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_royale%2F10.jpg?alt=media&token=303df58e-caa3-4bd9-a6e4-3ed08c16f7b9");
        royale.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_royale%2F12.jpg?alt=media&token=72775e09-ae38-4a51-ab92-e01322e17260");
        royale.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_royale%2F2.jpg?alt=media&token=8cae0dd8-4cbe-4568-b59b-f496fd90578c");
        royale.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_royale%2F2.jpg?alt=media&token=8cae0dd8-4cbe-4568-b59b-f496fd90578c");
        royale.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_royale%2F4.jpg?alt=media&token=4d360f41-7ed7-4c75-a147-c3afa54e1882");
        royale.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_royale%2F6.jpg?alt=media&token=590848a9-f10f-4ccd-9eb1-5a56bba3a73c");
        royale.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_royale%2F7.jpg?alt=media&token=e544bde1-d1a3-4afd-a67f-16b9eba9a4e8");
        royale.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_royale%2F8.jpg?alt=media&token=5f9475ad-1004-46a1-b264-3a62cf2ce8f5");
        empreendimentos = new Empreendimentos(
                "Residencial Royale",
                "opcao",
                "Venda: R$ 140.900,00 a partir",
                "Avaliação: R$ 180.000,00",
                R.drawable.img_royale,
                "opcao_royale",0, "+34 3224-5948",
                "Opcao",
                "• 51,62 até 58,41 m²\n• 2 quartos (1 suite)\n• 2 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Salão de festas*\n• Espaço comum para churrasqueira*\n• Portaria projetada para 24 h\n• Elevador\n• Entre outros...",
                "• Ainda não disponível!",
                "Faixa 2", royale, -18.947939, -48.350186);
        listaEmpreendimentos.add(empreendimentos);

        List<String> flam = new ArrayList<>();
        flam.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_resFlamboyant%2F1.jpeg?alt=media&token=274aebb0-3c4e-4211-b771-c87330923e9c");
        flam.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_resFlamboyant%2F2.jpeg?alt=media&token=25080132-1963-485a-b120-564a83e87eea");
        flam.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_resFlamboyant%2F3.jpeg?alt=media&token=781b859b-5d76-407e-8f32-4300657f750b");
        flam.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_resFlamboyant%2F4.jpeg?alt=media&token=0ed0a4bd-1882-4577-900f-56001c9e1e95");
        flam.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_resFlamboyant%2F5.jpeg?alt=media&token=e259237d-46ff-405f-ad8e-f6d7bab44a3f");
        flam.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_resFlamboyant%2F6.jpeg?alt=media&token=5e45a53c-7048-4a42-b64c-46702cefae51");
        flam.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_resFlamboyant%2F7.jpeg?alt=media&token=70f60464-5bcd-45b1-a7ad-1f24b0593153");
        flam.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_resFlamboyant%2F8.jpeg?alt=media&token=9ab4c3b0-ce11-49ba-a728-42d2351eee40");
        empreendimentos = new Empreendimentos(
                "Residencial Flamboyant",
                "opcao",
                "Venda: R$ 141.900,00",
                "Avaliação: R$ 167.000,00 a partir",
                R.drawable.img_flamboyant,
                "opcao_resFlamboyant",0, "+34 3224-5948",
                "Opcao",
                "• 51 m²\n• 2 quartos (1 suite)\n• 2 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Espaço para playground\n• Salão de festas*\n• Espaço comum para churrasqueira*\n• Elevador\n• Entre outros...",
                "• Ainda não disponível!",
                "Faixa 2", flam, 0.00000, 0.00000);
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Village Sul",
                "opcao",
                "Venda: R$ 141.900,00 a partir",
                "Avaliação: R$ 180.000,00",
                R.drawable.avatar_empreendimento,
                "opcao_villageSul",0, "+34 3224-5948",
                "Opcao",
                "• 51 m²\n• 2 quartos (1 suite)\n• 2 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Espaço para playground\n• Salão de festas*\n• Espaço comum para churrasqueira*\n• Elevador\n• Entre outros...",
                "• Rua Monte Roraima, 181\n• São Jorge",
                "Faixa 2", naoDisponivel, -18.9688751, -48.22366152);
        listaEmpreendimentos.add(empreendimentos);

        List<String> moradaPraia = new ArrayList<>();
        moradaPraia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_moradaPraia%2F2.jpeg?alt=media&token=955cf896-3729-4f8d-adc0-09a7e4622b3a");
        moradaPraia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_moradaPraia%2F3.jpeg?alt=media&token=5a68951d-1d19-4605-818a-91347856e4fa");
        moradaPraia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_moradaPraia%2F4.jpeg?alt=media&token=a2821003-7d55-4b86-a55a-bf637264d886");
        moradaPraia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_moradaPraia%2F5.jpeg?alt=media&token=26ec9d7d-8816-469c-a76c-26038259b79a");
        moradaPraia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_moradaPraia%2F6.jpeg?alt=media&token=8195e955-48c5-455f-8729-cb89440cf2ae");
        moradaPraia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_moradaPraia%2F7.jpeg?alt=media&token=0cff7e9f-af06-43a2-bf4d-b71f84de34a0");
        moradaPraia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fopcao%2Fopcao_moradaPraia%2F8.jpeg?alt=media&token=bcf88696-80a9-44f5-a047-057f32b02764");
        empreendimentos = new Empreendimentos(
                "Residencial Morada do Praia",
                "opcao",
                "Venda: R$ 181.000,00 a partir",
                "Avaliação: R$ 190.000,00",
                R.drawable.img_morada_praia,
                "opcao_moradaPraia",0, "+34 3224-5948",
                "Opcao",
                "• 59 m²\n• 2 quartos (1 suite)\n• 2 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Salão de festas e espaço para playground\n• Sacada\n• Elevador\n• Gás canalizado\n• Entre outros...",
                "• R. Graça Aranha, 481\n• Tubalina",
                "Faixa 2", moradaPraia, -18.940428, -48.297246);
        listaEmpreendimentos.add(empreendimentos);

        //PACHECO COMPLETO

        List<String> veneza = new ArrayList<>();
        veneza.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resVeneza%2F11.jpg?alt=media&token=d968b330-a9a0-41fb-b238-f423cc3011c8");
        veneza.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resVeneza%2F12.jpg?alt=media&token=908e4597-391a-4da2-aeee-fd81aedbc3de");
        veneza.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resVeneza%2F14.jpg?alt=media&token=20c8c62a-fb84-45ae-8e50-9bdc07e51bf4");
        veneza.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resVeneza%2F15.jpg?alt=media&token=6a0bc098-1fa0-4c0b-88de-6112b2dee463");
        veneza.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resVeneza%2F2.jpg?alt=media&token=61aead1e-d445-4c6d-a869-6d30276a6e00");
        veneza.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resVeneza%2F5.jpg?alt=media&token=fc28651f-0053-47cc-a318-458a7ddaa73f");
        veneza.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resVeneza%2F6.jpg?alt=media&token=76bde576-baa7-4b83-9404-8a23d73d7673");
        veneza.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resVeneza%2F9.jpg?alt=media&token=b61bb90e-f820-4d27-b1b4-34ca9380911d");
        empreendimentos = new Empreendimentos(
                "Residencial Veneza",
                "pacheco",
                "Venda: R$ 290.000,00 a partir",
                "Avaliação: R$ 300.000,00 a partir",
                R.drawable.img_veneza,
                "pacheco_resVeneza",0, "+34 3231-1098",
                "Pacheco",
                "• 67 m²\n• 2 quartos (1 suite)\n• 2 banheiros\n• 2 vagas na Garagem\n• Entre outros...",
                "• Estrutura para ar condicionado split\n• Estrutura para portaria 24h\n• 2 elevadores\n• Espaço de convivência com salão de festas\n• Entre outros...",
                "• R. João Velasco de Andrade, 218\n• Santa Mônica",
                "Acima", veneza, -18.912732, -48.252659);
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Unique",
                "pacheco",
                "Venda: R$ 355.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_residencial_unique,
                "pacheco_resUnique",0,"+34 3231-1098",
                "Pacheco",
                "• 88, 92 ou 98 m²\n• 2 ou 3 quartos (1 suite)\n• 2 banheiros\n• 2 ou 3 vagas na Garagem\n• Entre outros...",
                "• Estrutura para ar condicionado split\n• Estrutura para portaria 24h\n• 2 elevadores\n• Espaço de convivência com salão de festas\n• Entre outros...",
                "• R. Antônia Saltão de Almeida\n• Jardim Finotti",
                "Acima", naoDisponivel, -18.923696, -48.260475);
        listaEmpreendimentos.add(empreendimentos);

        List<String> boulevard = new ArrayList<>();
        boulevard.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resLidiceBou%2F10.jpg?alt=media&token=3382bbd4-9d02-45e1-9402-c739782a8049");
        boulevard.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resLidiceBou%2F12.jpg?alt=media&token=d896f569-3539-41ab-bcd2-117777890b2d");
        boulevard.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resLidiceBou%2F13.jpg?alt=media&token=7558c015-154f-4488-9176-a4bbbef626be");
        boulevard.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resLidiceBou%2F15.jpg?alt=media&token=b9a0b280-f590-4fb0-af45-e3de4e9ddb99");
        boulevard.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resLidiceBou%2F2.jpg?alt=media&token=92dee9ae-35a7-41c7-966e-df07236bffd8");
        boulevard.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resLidiceBou%2F3.jpg?alt=media&token=c350485c-08e8-4a31-b8f8-b870a43223bd");
        boulevard.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resLidiceBou%2F7.jpg?alt=media&token=3a9aa965-a7b0-4223-8100-77c515d872a0");
        boulevard.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resLidiceBou%2F8.jpg?alt=media&token=0ec560ae-322e-41d4-86b7-6bcd4e48d2a3");
        empreendimentos = new Empreendimentos(
                "Residencial Lídice Boulevard",
                "pacheco",
                "Venda: R$ 671.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_lidiceboulevard,
                "pacheco_resLidiceBou",0,"+34 3231-1098",
                "Pacheco",
                "• 120 e 125 m²\n• 3 quartos (3 suite)\n• 4 banheiros\n• 3 vagas na Garagem\n• Entre outros...",
                "• Estrutura para automação\n• 2 elevadores\n• Piscina com deck\n• Academia\n• Entre outros...",
                "• Rua Carajás, 1148\n• Lídice",
                "Acima", boulevard, -18.923962, -48.273261);
        listaEmpreendimentos.add(empreendimentos);

        List<String> evidence = new ArrayList<>();
        evidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resEvidence%2F1.jpg?alt=media&token=a49238b1-6cf3-4287-b5fb-1c6cf7b3a045");
        evidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resEvidence%2F2.jpg?alt=media&token=1b86f00c-f313-40f2-9410-b6a132f40355");
        evidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resEvidence%2F3.jpg?alt=media&token=12ee91e7-a7a3-4db9-aa09-3292ccdac1ab");
        evidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resEvidence%2F4.jpg?alt=media&token=d62cdf76-dfac-487a-a192-dd36ee9b43f1");
        evidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resEvidence%2F5.jpg?alt=media&token=2672aecb-08b7-4429-b576-211949bbcae6");
        evidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resEvidence%2F7.jpg?alt=media&token=0ff00ebc-3d9b-47ef-a172-3e05fbab7c79");
        evidence.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpacheco%2Fpacheco_resEvidence%2F8.jpg?alt=media&token=054e389e-b23a-421c-9a0d-c43a448567bb");
        empreendimentos = new Empreendimentos(
                "Residencial Evidence",
                "pacheco",
                "Venda: R$ 1.397.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_evidence,
                "pacheco_resEvidence",0,"+34 3231-1098",
                "Pacheco",
                "• 197 m²\n• 3 ou 4 quartos (3 ou 2 suite)\n• 4 banheiros\n• 3 vagas na Garagem\n• Entre outros...",
                "• Academia equipada, sauna e spa\n• Brinquedoteca\n• Espaço gourmet\n• 2 elevadores\n• Entre outros...",
                "• Rua Padre Anchieta, 46\n• Lídice",
                "Acima", evidence, -18.923221, -48.275812);
        listaEmpreendimentos.add(empreendimentos);

        //PDCA COMPLETO

        List<String> jardinsCerrado = new ArrayList<>();
        jardinsCerrado.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpdca%2Fpdca_jardinsCerrado%2F1.jpg?alt=media&token=5baa30e8-cc55-4662-a3c7-359fbcbb2ff9");
        jardinsCerrado.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpdca%2Fpdca_jardinsCerrado%2F3.jpg?alt=media&token=b56e669e-a25c-46ae-8a03-fbbd37470220");
        jardinsCerrado.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpdca%2Fpdca_jardinsCerrado%2F4.jpg?alt=media&token=d09ca2e8-d431-44b8-99aa-6671e6cdbc95");
        jardinsCerrado.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fpdca%2Fpdca_jardinsCerrado%2F5.jpg?alt=media&token=20f7efd4-1431-48a2-8ba0-c2935d862605");
        empreendimentos = new Empreendimentos(
                "Jardins do Cerrado",
                "pdca",
                "Venda: R$ 128.000,00",
                "Avaliação: R$ 128.000,00",
                R.drawable.img_jardimdocerrado,
                "pdca_jardinsCerrado",0, "+34 3291-8700",
                "PDCA",
                "• 44,20 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Casa em condomínio fechado",
                "• R. 2A3-02\n• Pequis",
                "Faixa 1,5", jardinsCerrado, -18.970602, -48.367926);
        listaEmpreendimentos.add(empreendimentos);

        //Portento COMPLETO

        List<String> laBelle = new ArrayList<>();
        laBelle.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fportento%2Fportento_laBelle%2F1.jpg?alt=media&token=a2cb5f19-cc67-47d6-a18a-78bb8a5e9555");
        empreendimentos = new Empreendimentos(
                "Residencial La Belle",
                "portento",
                "Venda: R$ 135.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_labelle,
                "portento_laBelle",1,
                "+34 3210-8714",
                "Portento",
                "• 42 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Garagem Coberta\n• Sacata em todas as unidades\n• Cozinha e sala interligadas\n• Varanda Gourmet com churrasqueira\n• Entre outros...",
                "• Rua Athos Paranhos, 920\n• Tubalina", "Faixa 2", laBelle,
                -18.939161, -48.299913);
        listaEmpreendimentos.add(empreendimentos);

        List<String> ravena = new ArrayList<>();
        ravena.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fportento%2Fportento_ravena%2F1.jpg?alt=media&token=6168f1dd-fc0a-43d5-a69b-24cba32fc1d1");
        empreendimentos = new Empreendimentos(
                "Residencial Ravena",
                "portento",
                "Venda: R$ 140.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_ravena,
                "portento_ravena",1,
                "+34 3210-8714",
                "Portento",
                "• 45 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "Ainda não disponível!",
                "• Rua Afonso Arinos de Melo Franco 382\n• Tubalina","Faixa 2", ravena,
                -18.933384, -48.299948);
        listaEmpreendimentos.add(empreendimentos);

        List<String> sevilha = new ArrayList<>();
        sevilha.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fportento%2Fportento_sevilha%2F1.jpg?alt=media&token=4b161816-f477-4ef6-8e62-1ebd8b8a4703");
        sevilha.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fportento%2Fportento_sevilha%2F2.jpg?alt=media&token=2cbee84d-0b1f-4ac6-b874-d4ae07cdf1e4");
        sevilha.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fportento%2Fportento_sevilha%2F3.jpg?alt=media&token=88503632-cd09-437e-8d4e-92c17962ee2b");
        empreendimentos = new Empreendimentos(
                "Residencial Sevilha",
                "portento",
                "Venda: R$ 144.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_sevilha,
                "portento_sevilha",1,"+34 3210-8714",
                "Portento",
                "• 46 e 47 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Cozinha e sala separadas\n• Bancadas em granito\n• Sacadas na sala e cozinha\n• Garagem com vaga dupla\n• Entre outros...",
                "• Av Alice de Oliveira e Silva, 200\n• Jardins das Palmeiras",
                "Faixa 2", sevilha,
                -18.9960109, -48.316545);
        listaEmpreendimentos.add(empreendimentos);

        List<String> valencia = new ArrayList<>();
        valencia.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fportento%2Fportento_valencia%2F1.jpg?alt=media&token=104c4223-2062-46a5-b6ba-457290db7136");
        empreendimentos = new Empreendimentos(
                "Residencial Valência",
                "portento",
                "Venda: R$ 145.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_valencia,
                "portento_valencia",1,"+34 3210-8714",
                "Portento",
                "• 47 e 48 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Cozinha e sala separadas\n• Bancadas em granito\n• Sacadas na sala e cozinha\n• Garagem com vaga dupla\n• Entre outros...",
                "• Rua Estrela do Sul, 2810\n• Martins",  "Faixa 2", valencia,
                -18.912071, -48.299931);
        listaEmpreendimentos.add(empreendimentos);

        List<String> milao = new ArrayList<>();
        milao.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fportento%2Fportento_milao%2F1.jpg?alt=media&token=199d36b9-0727-4719-bb5c-86dfd6a70193");
        milao.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fportento%2Fportento_milao%2F2.jpg?alt=media&token=082654a3-2f44-4ad0-a229-39b2447d716f");
        milao.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fportento%2Fportento_milao%2F3.jpg?alt=media&token=72a65da5-c2d9-4ae9-9398-73e2d13d574c");
        empreendimentos = new Empreendimentos(
                "Residencial Milão",
                "portento",
                "Venda: R$ 330.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_milao,
                "portento_milao",1,"+34 3210-8714",
                "Portento",
                "• 96 m²\n• 3 quartos (2 suite)\n• 3 banheiros\n• 2 vagas na Garagem\n• Entre outros...",
                "• Escadas e elevador\n• Varanda Gourmet com churrasqueira\n• Pontos para ar condicionado (4 pontos)\n• Janelas em blindex na área social\n• Entre outros...",
                "• Rua José Humberto Alves, 54\n• Copacabana", "Acima", milao,
                -18.937114, -48.283756);
        listaEmpreendimentos.add(empreendimentos);

        //R. Freitas COMPLETO
        List<String> bosque = new ArrayList<>();
        bosque.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_gameleiras%2F3.jpg?alt=media&token=ecfcdb12-cce2-449e-aa09-1b468323a91c");
        bosque.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_gameleiras%2F4.jpg?alt=media&token=a91fdaa4-9149-4a05-9239-3bf821c574a0");
        bosque.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_gameleiras%2F5.jpg?alt=media&token=c512b3b5-17f8-40e7-9eb9-b61c6c7143ae");
        bosque.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_gameleiras%2F6.jpg?alt=media&token=d82af679-f016-4df0-8599-dfbf90b24f5f");
        bosque.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_gameleiras%2F7.jpg?alt=media&token=9eeeaa4c-0ef8-454f-af55-5c4bad8d8b82");
        bosque.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_gameleiras%2F8.jpg?alt=media&token=9b8e70cc-f889-4174-b6fd-19bf127be5e1");
        empreendimentos = new Empreendimentos(
                "Condominio Bosque das Gameleiras",
                "rFreitas",
                "Venda: R$ 180.000,00 a partir",
                "Avaliação: R$ 187.000,00 a partir",
                R.drawable.img_bosquedasgameleiras,
                "rfreitas_gameleiras",0, "+34 3236-5566",
                "R Freitas",
                "• 64,90 ou 80,90 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Casas independentes (não geminadas)\n• Área de Lazer\n• Quadra Poliesportiva\n• Segurança\n• Entre outros...",
                "• R. do Marmelo\n• Pacaembu",
                "Faixa 2", bosque,
                -18.880146, -48.297098);
        listaEmpreendimentos.add(empreendimentos);

        List<String> aristides = new ArrayList<>();
        aristides.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_aristides%2F1.jpg?alt=media&token=443f11a1-4cc0-4362-a79d-9a9093d713fd");
        aristides.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_aristides%2F2.jpg?alt=media&token=1122310e-39ec-4547-a3d7-da843d2de161");
        aristides.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_aristides%2F3.jpg?alt=media&token=79270825-f1ec-458a-87e9-70a1137c57a0");
        aristides.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_aristides%2F4.jpg?alt=media&token=b5c17884-795f-49e9-ac23-a639ef4c3e92");
        aristides.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_aristides%2F5.jpg?alt=media&token=f77fdb16-88ac-4066-85a0-a9445e62be49");
        aristides.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_aristides%2F6.jpg?alt=media&token=d62be151-4eba-4212-83de-572c1262496b");
        aristides.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_aristides%2F7.jpg?alt=media&token=ad5a9a3f-3f6c-4af8-941c-e5c1a90612f5");
        empreendimentos = new Empreendimentos(
                "Edifício Aristides de Freitas",
                "rFreitas",
                "Venda: R$ 359.000,00 a partir",
                "Avaliação: R$ 400.000,00",
                R.drawable.img_aristidesdefreitas,
                "rfreitas_aristides",0, "+34 3236-5566",
                "R Freitas",
                "• 77 m²\n• 2 quartos (2 suite)\n• 2 banheiros\n• 2 vagas na Garagem\n• Entre outros...",
                "• 2 elevadores\n• Instalação para A/C split\n• Área de Lazer\n• \n• Entre outros...",
                "• Rua Eduardo Marquez, 350\n• Martins.",
                "Acima", aristides,
                -18.916850, -48.283689);
        listaEmpreendimentos.add(empreendimentos);

        List<String> uz = new ArrayList<>();
        uz.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_uzTower%2F1.jpg?alt=media&token=f538abe3-a226-4d59-a21d-58c1500c116c");
        uz.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_uzTower%2F2.jpg?alt=media&token=c6017cce-18b2-4d39-b0a6-20ae5c8923a7");
        uz.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_uzTower%2F3.jpg?alt=media&token=854c74f5-a304-4df1-8fc8-6ddffac0eea7");
        uz.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_uzTower%2F4.jpg?alt=media&token=a2ed6dbe-cd06-4df1-9bca-1a4fc6cdba15");
        uz.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_uzTower%2F5.jpg?alt=media&token=d833bb74-5be0-4e34-996f-168cab01ff39");
        uz.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2FrFreitas%2Frfreitas_uzTower%2F6.jpg?alt=media&token=807f8420-4ca8-4801-a046-d91e1e4595d6");
        empreendimentos = new Empreendimentos(
                "UZ Tower",
                "rFreitas",
                "Venda: R$ 384.544,03 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_uztower,
                "rfreitas_uzTower",0, "+34 3236-5566",
                "R Freitas",
                "• Até 84 m²\n• 2 quartos (1 suite)\n• 2 banheiros\n• - vagas na Garagem\n• Entre outros...",
                "• Espaço FItness\n• Espaço Gourmet\n• Piscina\n• Otima localização\n• Entre outros...",
                "• R. Quinze de Novembro, 743\n• Centro",
                "Acima", uz,
                -18.924512, -48.289580);
        listaEmpreendimentos.add(empreendimentos);

        //Realiza COMPLETO

        List<String> anita = new ArrayList<>();
        anita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Frealiza%2Frealiza_anitaRes%2F1.jpeg?alt=media&token=b5366c5d-51b3-4ace-8714-36dbf646d9cc");
        anita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Frealiza%2Frealiza_anitaRes%2F2.jpeg?alt=media&token=07db6789-6174-43d4-9d84-cbbf4996e5ca");
        anita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Frealiza%2Frealiza_anitaRes%2F3.jpeg?alt=media&token=ac461ffb-792c-460c-8af3-3c01b254c47d");
        anita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Frealiza%2Frealiza_anitaRes%2F4.jpeg?alt=media&token=1017bda3-9531-4eb1-96db-881ce871963b");
        anita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Frealiza%2Frealiza_anitaRes%2F5.jpeg?alt=media&token=f20df009-77ab-4938-a53c-2b07a6c34e09");
        anita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Frealiza%2Frealiza_anitaRes%2F6.jpeg?alt=media&token=9f2fb33c-ce7c-415d-bdcf-d323d0a37450");
        anita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Frealiza%2Frealiza_anitaRes%2F7.jpeg?alt=media&token=af99c8a5-c447-4938-b9a7-a1b6c9804b2a");
        anita.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Frealiza%2Frealiza_anitaRes%2F8.jpeg?alt=media&token=05116126-799d-4eb4-970a-bc02a8adf704");
        empreendimentos = new Empreendimentos(
                "Anita Residence",
                "realiza",
                "Venda: R$ 310.500,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.avatar_empreendimento,
                "realiza_anitaRes",0, "+34 3212-2311",
                "Realiza",
                "• 68,66 até 191,76 m²\n• 2 ou 3 quartos (2 ou 3 suite)\n• 3 ou 4 banheiros\n• 3 vagas na Garagem\n• Entre outros...",
                "• SEGURANÇA 24H COM MONITORAMENTO POR CÂMERA DE VÍDEO\n• ACADEMIA\n• PLAYGROUND\n• PISCINA\n• Entre outros...",
                "• Rua Rezende\n• Centro",
                "Acima", anita,
                -18.918045, -48.270920);
        listaEmpreendimentos.add(empreendimentos);

        List<String> village = new ArrayList<>();
        village.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Frealiza%2Frealiza_villageParII%2F1.jpeg?alt=media&token=64cd4cd1-153b-4f3b-a0a5-9a6abe6477eb");
        village.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Frealiza%2Frealiza_villageParII%2F10.jpeg?alt=media&token=c8edf9f2-50a2-435a-91f3-8f705147eeae");
        village.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Frealiza%2Frealiza_villageParII%2F2.jpeg?alt=media&token=caa966ed-6aba-4481-a9bb-ffa43c03f854");
        village.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Frealiza%2Frealiza_villageParII%2F4.jpeg?alt=media&token=f7af789f-41ec-4398-93ef-adf815661904");
        village.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Frealiza%2Frealiza_villageParII%2F6.jpeg?alt=media&token=fb907a12-92d6-42c3-b7f5-bc95826dcb46");
        village.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Frealiza%2Frealiza_villageParII%2F7.jpeg?alt=media&token=291b1234-bce7-4337-ac1b-83058ea950f1");
        village.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Frealiza%2Frealiza_villageParII%2F8.jpeg?alt=media&token=a481c619-6360-4773-be98-faff9af91c0e");
        village.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Frealiza%2Frealiza_villageParII%2F9.jpeg?alt=media&token=e3cbada1-a322-4082-8f38-27b4d4092353");
        empreendimentos = new Empreendimentos(
                "Village Paradiso II",
                "realiza",
                "Venda: R$ 619.368,10 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_village_paradiso,
                "realiza_villageParII",0,"+34 3212-2311",
                "Realiza",
                "• 144,22 até 200 m²\n• 3 ou 4 quartos (3 ou 4 suite)\n• 4 banheiros\n• 3 vagas na Garagem\n• Entre outros...",
                "• ESPAÇO GOURMET\n• GUARDA MOTORIZADA\n• PLAYGROUND\n• QUADRA POLIESPORTIVA COM SAUNA\n• Entre outros...",
                "• Rua E Lote 02 Quadra F\n• Granja Marileusa",
                "Acima", village,
                -18.874486, -48.246085);
        listaEmpreendimentos.add(empreendimentos);

        //TROIA

        empreendimentos = new Empreendimentos(
                "Splendia Residence",
                "troia",
                "Venda: R$ 540.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.avatar_empreendimento,
                "troia_splendiaRes",0, "+34 3255-3113",
                "Troia",
                "• 135 m²\n• 3 quartos (1 suite)\n• 2 banheiros\n• 2 a 3 vagas na Garagem\n• Entre outros...",
                "• Salão de festas\n• Espaço gourmet\n• Espaço Brinquedoteca\n• 2 Elevadores\n• Entre outros...",
                "• Rua Senhor dos Passos, 590\n• Tubalina ",
                "Acima", naoDisponivel,
                -18.936585, -48.294116);
        listaEmpreendimentos.add(empreendimentos);

        //URBANI

        empreendimentos = new Empreendimentos(
                "Residencial Napoli",
                "urbani",
                "Venda: R$ 129.900,00 a partir",
                "Avaliação: R$ 163.000,00 a partir",
                R.drawable.avatar_empreendimento,
                "urbani_resNapoli",0, "+34 3257-3001",
                "Urbani",
                "• 43 e 45,35 m²\n• 2 quartos (0 suite)\n• 1 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• Playground\n• Academia\n• Espaço de Lazer\n• Piscina\n• Entre outros...",
                "• Av. Castela\n• Laranjeiras",
                "Faixa 2", naoDisponivel,-18.963645, -48.248534);
        listaEmpreendimentos.add(empreendimentos);

        //Vivamus
        List<String> start = new ArrayList<>();
        start.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fvivamus%2Fvivamus_startTower%2F2.jpg?alt=media&token=44d0ea65-0543-4b2c-86b6-167c8c15db2f");
        start.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fvivamus%2Fvivamus_startTower%2F3.jpg?alt=media&token=b6e64051-7414-45fd-b3fb-853a891f1331");
        start.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fvivamus%2Fvivamus_startTower%2F4.jpg?alt=media&token=678e854b-5673-47a5-a301-dab2fee0ccc3");
        start.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fvivamus%2Fvivamus_startTower%2F5.jpg?alt=media&token=6a770d91-cbea-47c0-a4d5-177fa2b0b7fb");
        start.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fvivamus%2Fvivamus_startTower%2F6.jpg?alt=media&token=49ca04e2-9326-4dec-b864-60eff348b924");
        empreendimentos = new Empreendimentos(
                "Start Tower Vivamus JH II",
                "vivamus",
                "Venda: R$ 128.000,00",
                "Avaliação: R$ R$ 128.000,00",
                R.drawable.img_starttower,
                "vivamus_startTower",0, "+34 3301-2323",
                "Vivamus",
                "• 47 m²\n• 2 quartos (1 suite)\n• 2 banheiros\n• 1 vagas na Garagem\n• Entre outros...",
                "• 100% Acessível\n• Salão de Festas\n• Playground\n• Entre outros...",
                "• Alameda José de Oliveira Guimarães\n• Jardim Holanda",
                "Faixa 1,5", start,
                -18.9572098, -48.322110);
        listaEmpreendimentos.add(empreendimentos);

        List<String> smart = new ArrayList<>();
        smart.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fvivamus%2Fvivamus_smartTower%2F2.jpg?alt=media&token=42e1028d-24e1-478c-8668-c850158339b6");
        smart.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fvivamus%2Fvivamus_smartTower%2F3.jpg?alt=media&token=f62d7c4d-00b2-41db-b4f6-b7eaab5ea642");
        smart.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fvivamus%2Fvivamus_smartTower%2F4.jpg?alt=media&token=07aeec5a-30f3-43e3-95d8-f04ec757611d");
        smart.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fvivamus%2Fvivamus_smartTower%2F5.jpg?alt=media&token=d7ccb78a-a382-4e42-ac31-3d3b8733b648");
        smart.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fvivamus%2Fvivamus_smartTower%2F5.jpg?alt=media&token=d7ccb78a-a382-4e42-ac31-3d3b8733b648");
        smart.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fvivamus%2Fvivamus_smartTower%2F8.jpg?alt=media&token=c72cede4-9b6c-458b-8ee9-92e71340b2a8");
        smart.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fvivamus%2Fvivamus_smartTower%2F9.jpg?alt=media&token=27ee5e23-1f89-444e-89da-9affd5aa281a");
        smart.add("https://firebasestorage.googleapis.com/v0/b/eurezzolve-ec.appspot.com/o/empreendimentos%2Fvivamus%2Fvivamus_smartTower%2FSem%20T%C3%ADtulo-1.jpg?alt=media&token=fa350e15-6d93-4303-b09f-7a3359d15070");
        empreendimentos = new Empreendimentos(
                "Smart Tower Vivamus JH II",
                "vivamus",
                "Venda: R$ 151.990,00 a partir",
                "Avaliação: R$ 183.000,00",
                R.drawable.img_smarttower,
                "vivamus_smartTower",0,"+34 3301-2323",
                "Vivamus",
                "• 57 m²\n• 2 quartos (1 suite)\n• 2 banheiros\n• 2 vagas na Garagem\n• Entre outros...",
                "• Pista de Corrida\n• Piscinas\n• Quadra Poliesportiva\n• Espaço Gourmet\n• Entre outros...",
                "• Alameda José de Oliveira Guimarães\n• Jardim Holanda",
                "Faixa 2", smart,
                -18.957149, -48.322014);
        listaEmpreendimentos.add(empreendimentos);

        return listaEmpreendimentos;
    }
}
