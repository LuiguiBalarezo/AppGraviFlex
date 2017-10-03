package com.scriptgo.www.graviflex.apilinks;

import com.scriptgo.www.graviflex.responses.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by BALAREZO on 10/08/2017.
 */

public interface ApiLinks {

    /*
   * LOGIN
   * */
    @FormUrlEncoded
    @POST("usuario/login")
    Call<LoginResponse> processLogin(@Field("edt_usuario") String usuario, @Field("edt_clave") String clave);

//    /*
//    *  OBRAS
//    **/
//    @GET("works/{edt_iduser}/")
//    @Headers(ConstansHelps.ACCESS_TOKEN)
//    Call<ObrasResponse> processGetAllObra(@Path("edt_iduser") int iduser);
//
//    @GET("works/{edt_iduser}/getall_id_name")
//    @Headers(ConstansHelps.ACCESS_TOKEN)
//    Call<ObrasResponse> processGetAllObraActive_ID_NAME(@Path("edt_iduser") int iduser);
//
//    @FormUrlEncoded
//    @POST("work/create")
//    @Headers(ConstansHelps.ACCESS_TOKEN)
//    Call<ObrasResponse> processCreateObra(@Field("edt_id") Integer id,
//                                          @Field("edt_idlocal") Integer idlocal,
//                                          @Field("edt_nombre") String namework,
//                                          @Field("createdAtLocalDB") Date datecreatelocal,
//                                          @Field("edt_iduser") Integer iduser);
//
//    @FormUrlEncoded
//    @POST("work/update")
//    @Headers(ConstansHelps.ACCESS_TOKEN)
//    Call<ObrasResponse> processUpdateObra(@Field("edt_id") Integer id,
//                                          @Field("edt_nombre") String namework,
//                                          @Field("updatedAtLocalDB") Date dateupdatelocal,
//                                          @Field("edt_iduser") Integer iduser);
//
//    @FormUrlEncoded
//    @POST("work/sync")
//    @Headers(ConstansHelps.ACCESS_TOKEN)
//    Call<ObrasResponse> processSyncObra(@Field("edt_id") Integer id,
//                                        @Field("edt_idlocal") Integer idlocal,
//                                        @Field("edt_nombre") String namework,
//                                        @Field("createdAtLocalDB") Date datecreatelocal,
//                                        @Field("updatedAtLocalDB") Date dateupdatelocal,
//                                        @Field("edt_iduser") Integer iduser);
//
//
//    /*
//   *  EGRESOS
//   **/
//    @GET("{edt_iduser}/expenditure/work/{edt_idobra}")
//    @Headers(ConstansHelps.ACCESS_TOKEN)
//    Call<EgresoResponse> processGetAllEgresoByObra(@Path("edt_iduser") int iduser, @Path("edt_idobra") int idobra);
//
//    @GET("{edt_iduser}/expenditure/work/{edt_idobra}/totalmoney")
//    @Headers(ConstansHelps.ACCESS_TOKEN)
//    Call<DineroResponse> processGetAllDineroEgresoByObra(@Path("edt_iduser") int iduser, @Path("edt_idobra") int idobra);
//
//
//    @FormUrlEncoded
//    @POST("{edt_iduser}/expenditure/create")
//    @Headers(ConstansHelps.ACCESS_TOKEN)
//    Call<EgresoResponse> processCreateEgreso(@Field("edt_id") Integer id,
//                                             @Field("edt_idlocal") Integer idlocal,
//                                             @Field("edt_idobra") Integer idobra,
//                                             @Field("edt_fecha") Date fecha,
//                                             @Field("edt_numero") int numero,
//                                             @Field("edt_monto") double monto,
//                                             @Field("edt_imagen") String image,
//                                             @Field("createdAtLocalDB") Date datecreatelocal,
//                                             @Path("edt_iduser") Integer iduser);
//
//
//    /*
//  *  INGRESOS
//  **/
//    @GET("{edt_iduser}/entry/work/{edt_idobra}")
//    @Headers(ConstansHelps.ACCESS_TOKEN)
//    Call<IngresoResponse> processGetAllIngresoByObra(@Path("edt_iduser") int iduser, @Path("edt_idobra") int idobra);
//
//    @GET("{edt_iduser}/entry/work/{edt_idobra}/totalmoney")
//    @Headers(ConstansHelps.ACCESS_TOKEN)
//    Call<DineroResponse> processGetAllDineroIngresoByObra(@Path("edt_iduser") int iduser, @Path("edt_idobra") int idobra);
//
//    @FormUrlEncoded
//    @POST("{edt_iduser}/entry/create")
//    @Headers(ConstansHelps.ACCESS_TOKEN)
//    Call<IngresoResponse> processCreateIngreso(@Field("edt_id") Integer id,
//                                               @Field("edt_idlocal") Integer idlocal,
//                                               @Field("edt_idobra") Integer idobra,
//                                               @Field("edt_fecha") Date fecha,
//                                               @Field("edt_numero") int numero,
//                                               @Field("edt_monto") double monto,
//                                               @Field("edt_imagen") String image,
//                                               @Field("createdAtLocalDB") Date datecreatelocal,
//                                               @Path("edt_iduser") Integer iduser);

}
