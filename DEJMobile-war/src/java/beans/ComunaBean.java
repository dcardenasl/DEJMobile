/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Centro de Trabajo
 */
@ManagedBean
@ViewScoped
@Named(value = "comunaBean")
public class ComunaBean {

    /**
     * Creates a new instance of ComunaBean
     */
    private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
    private String region;
    private String comuna;
    private Map<String, String> regiones;
    private Map<String, String> comunas;

    public ComunaBean() {
    }

    @PostConstruct
    public void init() {
        regiones = new HashMap<String, String>();
        regiones.put("Región de Arica y Parinacota", "Región de Arica y Parinacota");
        regiones.put("Región de Tarapacá", "Región de Tarapacá");
        regiones.put("Región de Antofagasta", "Región de Antofagasta");
        regiones.put("Región de Atacama", "Región de Atacama");
        regiones.put("Región de Coquimbo", "Región de Coquimbo");
        regiones.put("Región de Valparaíso", "Región de Valparaíso");
        regiones.put("Región del Libertador General Bernardo O'Higgins", "Región del Libertador General Bernardo O'Higgins");
        regiones.put("Región del Maule", "Región del Maule");
        regiones.put("Región del Biobío", "Región del Biobío");
        regiones.put("Región de la Araucanía", "Región de la Araucanía");
        regiones.put("Región de Los Ríos", "Región de Los Ríos");
        regiones.put("Región de Los Lagos", "Región de Los Lagos");
        regiones.put("Región de Aysén del General Carlos Ibáñez del Campo", "Región de Aysén del General Carlos Ibáñez del Campo");
        regiones.put("Región de Magallanes y de la Antártica Chilena", "Región de Magallanes y de la Antártica Chilena");
        regiones.put("Región Metropolitana de Santiago", "Región Metropolitana de Santiago");

        Map<String, String> map = new HashMap<String, String>();
        map.put("Arica", "Arica");
        map.put("Camarones", "Camarones");
        map.put("General Lagos", "General Lagos");
        map.put("Putre", "Putre");
        data.put("Región de Arica y Parinacota", map);

        map = new HashMap<String, String>();
        map.put("Alto Hospicio", "Alto Hospicio");
        map.put("Camiña", "Camiña");
        map.put("Colchane", "Colchane");
        map.put("Huara", "Huara");
        map.put("Iquique", "Iquique");
        map.put("Pica", "Pica");
        map.put("Pozo Almonte", "Pozo Almonte");
        data.put("Región de Tarapacá", map);

        map = new HashMap<String, String>();
        map.put("Antofagasta", "Antofagasta");
        map.put("Calama", "Calama");
        map.put("María Elena", "María Elena");
        map.put("Mejillones", "Mejillones");
        map.put("Ollagüe", "Ollagüe");
        map.put("San Pedro de Atacama", "San Pedro de Atacama");
        map.put("Sierra Gorda", "Sierra Gorda");
        map.put("Taltal", "Taltal");
        map.put("Tocopilla", "Tocopilla");
        data.put("Región de Antofagasta", map);

        map = new HashMap<String, String>();
        map.put("Alto del Carmen", "Alto del Carmen");
        map.put("Caldera", "Caldera");
        map.put("Chañaral", "Chañaral");
        map.put("Copiapó", "Copiapó");
        map.put("Diego de Almagro", "Diego de Almagro");
        map.put("Freirina", "Freirina");
        map.put("Huasco", "Huasco");
        map.put("Tierra Amarilla", "Tierra Amarilla");
        map.put("Vallenar", "Vallenar");
        data.put("Región de Atacama", map);

        map = new HashMap<String, String>();
        map.put("Andacollo", "Andacollo");
        map.put("Canela", "Canela");
        map.put("Combarbalá", "Combarbalá");
        map.put("Coquimbo", "Coquimbo");
        map.put("Illapel", "Illapel");
        map.put("La Higuera", "La Higuera");
        map.put("La Serena", "La Serena");
        map.put("Los Vilos", "Los Vilos");
        map.put("Monte Patria", "Monte Patria");
        map.put("Ovalle", "Ovalle");
        map.put("Paihuano", "Paihuano");
        map.put("Punitaqui", "Punitaqui");
        map.put("Río Hurtado", "Río Hurtado");
        map.put("Salamanca", "Salamanca");
        map.put("Vicuña", "Vicuña");
        data.put("Región de Coquimbo", map);

        map = new HashMap<String, String>();
        map.put("Algarrobo", "Algarrobo");
        map.put("Cabildo", "Cabildo");
        map.put("Calle Larga", "Calle Larga");
        map.put("Cartagena", "Cartagena");
        map.put("Casablanca", "Casablanca");
        map.put("Catemu", "Catemu");
        map.put("Concón", "Concón");
        map.put("El Quisco", "El Quisco");
        map.put("El Tabo", "El Tabo");
        map.put("Hijuelas", "Hijuelas");
        map.put("Isla de Pascua", "Isla de Pascua");
        map.put("Juan Fernández", "Juan Fernández");
        map.put("La Calera", "La Calera");
        map.put("La Cruz", "La Cruz");
        map.put("La Ligua", "La Ligua");
        map.put("Limache", "Limache");
        map.put("Llaillay", "Llaillay");
        map.put("Los Andes", "Los Andes");
        map.put("Nogales", "Nogales");
        map.put("Olmué", "Olmué");
        map.put("Panquehue", "Panquehue");
        map.put("Papudo", "Papudo");
        map.put("Petorca", "Petorca");
        map.put("Puchuncaví", "Puchuncaví");
        map.put("Putaendo", "Putaendo");
        map.put("Quillota", "Quillota");
        map.put("Quilpué", "Quilpué");
        map.put("Quintero", "Quintero");
        map.put("Rinconada de Los Andes", "Rinconada de Los Andes");
        map.put("San Antonio", "San Antonio");
        map.put("Santo Domingo", "Santo Domingo");
        map.put("San Esteban", "San Esteban");
        map.put("San Felipe", "San Felipe");
        map.put("Santa María", "Santa María");
        map.put("Santo Domingo", "Santo Domingo");
        map.put("Valparaíso", "Valparaíso");
        map.put("Villa Alemana", "Villa Alemana");
        map.put("Viña del Mar", "Viña del Mar");
        map.put("Zapallar", "Zapallar");
        data.put("Región de Valparaíso", map);

        map = new HashMap<String, String>();
        map.put("Chépica", "Chépica");
        map.put("Chimbarongo", "Chimbarongo");
        map.put("Codegua", "Codegua");
        map.put("Coínco", "Coínco");
        map.put("Coltauco", "Coltauco");
        map.put("Doñihue", "Doñihue");
        map.put("Graneros", "Graneros");
        map.put("La Estrella", "La Estrella");
        map.put("Las Cabras", "Las Cabras");
        map.put("Litueche", "Litueche");
        map.put("Lolol", "Lolol");
        map.put("Machalí", "Machalí");
        map.put("Malloa", "Malloa");
        map.put("Marchigüe", "Marchigüe");
        map.put("Nancagua", "Nancagua");
        map.put("Navidad", "Navidad");
        map.put("Olivar", "Olivar");
        map.put("Palmilla", "Palmilla");
        map.put("Paredones", "Paredones");
        map.put("Peralillo", "Peralillo");
        map.put("Peumo", "Peumo");
        map.put("Pichidegua", "Pichidegua");
        map.put("Pichilemu", "Pichilemu");
        map.put("Placilla", "Placilla");
        map.put("Pumanque", "Pumanque");
        map.put("Quinta de Tilcoco", "Quinta de Tilcoco");
        map.put("Rancagua", "Rancagua");
        map.put("Requínoa", "Requínoa");
        map.put("Rengo", "Rengo");
        map.put("San Fernando", "San Fernando");
        map.put("San Francisco de Mostazal", "San Francisco de Mostazal");
        map.put("San Vicente de Tagua Tagua", "San Vicente de Tagua Tagua");
        map.put("Santa Cruz", "Santa Cruz");
        data.put("Región del Libertador General Bernardo O'Higgins", map);

        map = new HashMap<String, String>();
        map.put("Cauquenes", "Cauquenes");
        map.put("Chanco", "Chanco");
        map.put("Colbún", "Colbún");
        map.put("Constitución", "Constitución");
        map.put("Curepto", "Curepto");
        map.put("Curicó", "Curicó");
        map.put("Empedrado", "Empedrado");
        map.put("Hualañé", "Hualañé");
        map.put("Licantén", "Licantén");
        map.put("Linares", "Linares");
        map.put("Longaví", "Longaví");
        map.put("Maule", "Maule");
        map.put("Molina", "Molina");
        map.put("Parral", "Parral");
        map.put("Pelarco", "Pelarco");
        map.put("Pelluhue", "Pelluhue");
        map.put("Pencahue", "Pencahue");
        map.put("Rauco", "Rauco");
        map.put("Retiro", "Retiro");
        map.put("Río Claro", "Río Claro");
        map.put("Romeral", "Romeral");
        map.put("Sagrada Familia", "Sagrada Familia");
        map.put("San Clemente", "San Clemente");
        map.put("San Javier de Loncomilla", "San Javier de Loncomilla");
        map.put("San Rafael", "San Rafael");
        map.put("Talca", "Talca");
        map.put("Teno", "Teno");
        map.put("Vichuquén", "Vichuquén");
        map.put("Villa Alegre", "Villa Alegre");
        map.put("Yerbas Buenas", "Yerbas Buenas");
        data.put("Región del Maule", map);

        map = new HashMap<String, String>();
        map.put("Alto Biobío", "Alto Biobío");
        map.put("Antuco", "Antuco");
        map.put("Arauco", "Arauco");
        map.put("Bulnes", "Bulnes");
        map.put("Cabrero", "Cabrero");
        map.put("Cañete", "Cañete");
        map.put("Chiguayante", "Chiguayante");
        map.put("Chillán", "Chillán");
        map.put("Chillán Viejo", "Chillán Viejo");
        map.put("Cobquecura", "Cobquecura");
        map.put("Coelemu", "Coelemu");
        map.put("Coihueco", "Coihueco");
        map.put("Concepción", "Concepción");
        map.put("Contulmo", "Contulmo");
        map.put("Coronel", "Coronel");
        map.put("Curanilahue", "Curanilahue");
        map.put("Florida", "Florida");
        map.put("El Carmen", "El Carmen");
        map.put("Hualpén", "Hualpén");
        map.put("Hualqui", "Hualqui");
        map.put("Laja", "Laja");
        map.put("Lebu", "Lebu");
        map.put("Los Álamos", "Los Álamos");
        map.put("Los Ángeles", "Los Ángeles");
        map.put("Lota", "Lota");
        map.put("Mulchén", "Mulchén");
        map.put("Nacimiento", "Nacimiento");
        map.put("Negrete", "Negrete");
        map.put("Ninhue", "Ninhue");
        map.put("Ñiquén", "Ñiquén");
        map.put("Pemuco", "Pemuco");
        map.put("Penco", "Penco");
        map.put("Pinto", "Pinto");
        map.put("Portezuelo", "Portezuelo");
        map.put("Quilaco", "Quilaco");
        map.put("Quilleco", "Quilleco");
        map.put("Quillón", "Quillón");
        map.put("Quirihue", "Quirihue");
        map.put("Ránquil", "Ránquil");
        map.put("San Carlos", "San Carlos");
        map.put("San Fabián", "San Fabián");
        map.put("San Ignacio", "San Ignacio");
        map.put("San Nicolás", "San Nicolás");
        map.put("San Pedro de la Paz", "San Pedro de la Paz");
        map.put("San Rosendo", "San Rosendo");
        map.put("Santa Bárbara", "Santa Bárbara");
        map.put("Santa Juana", "Santa Juana");
        map.put("Talcahuano", "Talcahuano");
        map.put("Tirúa", "Tirúa");
        map.put("Treguaco", "Treguaco");
        map.put("Tomé", "Tomé");
        map.put("Tucapel", "Tucapel");
        map.put("Yumbel", "Yumbel");
        map.put("Yungay", "Yungay");
        data.put("Región del Biobío", map);

        map = new HashMap<String, String>();
        map.put("Angol", "Angol");
        map.put("Carahue", "Carahue");
        map.put("Cholchol", "Cholchol");
        map.put("Collipulli", "Collipulli");
        map.put("Cunco", "Cunco");
        map.put("Curacautín", "Curacautín");
        map.put("Curarrehue", "Curarrehue");
        map.put("Ercilla", "Ercilla");
        map.put("Freire", "Freire");
        map.put("Galvarino", "Galvarino");
        map.put("Gorbea", "Gorbea");
        map.put("Lautaro", "Lautaro");
        map.put("Loncoche", "Loncoche");
        map.put("Lonquimay", "Lonquimay");
        map.put("Los Sauces", "Los Sauces");
        map.put("Lumaco", "Lumaco");
        map.put("Melipeuco", "Melipeuco");
        map.put("Nueva Imperial", "Nueva Imperial");
        map.put("Padre Las Casas", "Padre Las Casas");
        map.put("Perquenco", "Perquenco");
        map.put("Pitrufquén", "Pitrufquén");
        map.put("Pucón", "Pucón");
        map.put("Purén", "Purén");
        map.put("Renaico", "Renaico");
        map.put("Temuco", "Temuco");
        map.put("Teodoro Schmidt", "Teodoro Schmidt");
        map.put("Toltén", "Toltén");
        map.put("Traiguén", "Traiguén");
        map.put("Victoria", "Victoria");
        map.put("Vilcún", "Vilcún");
        map.put("Villarrica", "Villarrica");
        data.put("Región de la Araucanía", map);

        map = new HashMap<String, String>();
        map.put("Corral", "Corral");
        map.put("Futrono", "Futrono");
        map.put("Lanco", "Lanco");
        map.put("La Unión", "La Unión");
        map.put("Lago Ranco", "Lago Ranco");
        map.put("Los Lagos", "Los Lagos");
        map.put("Máfil", "Máfil");
        map.put("Mariquina", "Mariquina");
        map.put("Paillaco", "Paillaco");
        map.put("Panguipulli", "Panguipulli");
        map.put("Río Bueno", "Río Bueno");
        map.put("Valdivia", "Valdivia");
        data.put("Región de Los Ríos", map);

        map = new HashMap<String, String>();
        map.put("Ancud", "Ancud");
        map.put("Calbuco", "Calbuco");
        map.put("Castro", "Castro");
        map.put("Chaitén", "Chaitén");
        map.put("Chonchi", "Chonchi");
        map.put("Cochamó", "Cochamó");
        map.put("Curaco de Vélez", "Curaco de Vélez");
        map.put("Dalcahue", "Dalcahue");
        map.put("Fresia", "Fresia");
        map.put("Frutillar", "Frutillar");
        map.put("Futaleufú", "Futaleufú");
        map.put("Hualaihué", "Hualaihué");
        map.put("Llanquihue", "Llanquihue");
        map.put("Los Muermos", "Los Muermos");
        map.put("Maullín", "Maullín");
        map.put("Osorno", "Osorno");
        map.put("Palena", "Palena");
        map.put("Puerto Montt", "Puerto Montt");
        map.put("Puerto Octay", "Puerto Octay");
        map.put("Puerto Varas", "Puerto Varas");
        map.put("Puqueldón", "Puqueldón");
        map.put("Purranque", "Purranque");
        map.put("Puyehue", "Puyehue");
        map.put("Queilén", "Queilén");
        map.put("Quellón", "Quellón");
        map.put("Quemchi", "Quemchi");
        map.put("Quinchao", "Quinchao");
        map.put("Río Negro", "Río Negro");
        map.put("San Pablo", "San Pablo");
        map.put("San Juan de la Costa", "San Juan de la Costa");
        data.put("Región de Los Lagos", map);

        map = new HashMap<String, String>();
        map.put("Aysén", "Aysén");
        map.put("Chile Chico", "Chile Chico");
        map.put("Cisnes", "Cisnes");
        map.put("Cochrane", "Cochrane");
        map.put("Coyhaique", "Coyhaique");
        map.put("Guaitecas", "Guaitecas");
        map.put("Lago Verde", "Lago Verde");
        map.put("O'Higgins", "O'Higgins");
        map.put("Río Ibáñez", "Río Ibáñez");
        map.put("Tortel", "Tortel");
        data.put("Región de Aysén del General Carlos Ibáñez del Campo", map);

        map = new HashMap<String, String>();
        map.put("Antártica", "Antártica");
        map.put("Cabo de Hornos", "Cabo de Hornos");
        map.put("Laguna Blanca", "Laguna Blanca");
        map.put("Natales", "Natales");
        map.put("Porvenir", "Porvenir");
        map.put("Primavera", "Primavera");
        map.put("Punta Arenas", "Punta Arenas");
        map.put("Río Verde", "Río Verde");
        map.put("San Gregorio", "San Gregorio");
        map.put("Timaukel", "Timaukel");
        map.put("Torres del Paine", "Torres del Paine");
        data.put("Región de Magallanes y de la Antártica Chilena", map);

        map = new HashMap<String, String>();
        map.put("Alhué", "Alhué");
        map.put("Buin", "Buin");
        map.put("Calera de Tango", "Calera de Tango");
        map.put("Cerrillos", "Cerrillos");
        map.put("Cerro Navia", "Cerro Navia");
        map.put("Colina", "Colina");
        map.put("Conchalí", "Conchalí");
        map.put("Curacaví", "Curacaví");
        map.put("El Bosque", "El Bosque");
        map.put("El Monte", "El Monte");
        map.put("Estación Central", "Estación Central");
        map.put("Huechuraba", "Huechuraba");
        map.put("Independencia", "Independencia");
        map.put("Isla de Maipo", "Isla de Maipo");
        map.put("Lampa", "Lampa");
        map.put("La Cisterna", "La Cisterna");
        map.put("La Granja", "La Granja");
        map.put("La Florida", "La Florida");
        map.put("La Pintana", "La Pintana");
        map.put("La Reina", "La Reina");
        map.put("Las Condes", "Las Condes");
        map.put("Lo Barnechea", "Lo Barnechea");
        map.put("Lo Espejo", "Lo Espejo");
        map.put("Lo Prado", "Lo Prado");
        map.put("Macul", "Macul");
        map.put("Maipú", "Maipú");
        map.put("María Pinto", "María Pinto");
        map.put("Melipilla", "Melipilla");
        map.put("Ñuñoa", "Ñuñoa");
        map.put("Padre Hurtado", "Padre Hurtado");
        map.put("Paine", "Paine");
        map.put("Pedro Aguirre Cerda", "Pedro Aguirre Cerda");
        map.put("Peñaflor", "Peñaflor");
        map.put("Peñalolén", "Peñalolén");
        map.put("Pirque", "Pirque");
        map.put("Providencia", "Providencia");
        map.put("Pudahuel", "Pudahuel");
        map.put("Puente Alto", "Puente Alto");
        map.put("Quilicura", "Quilicura");
        map.put("Quinta Normal", "Quinta Normal");
        map.put("Recoleta", "Recoleta");
        map.put("Renca", "Renca");
        map.put("San Bernardo", "San Bernardo");
        map.put("San Joaquín", "San Joaquín");
        map.put("San José de Maipo", "San José de Maipo");
        map.put("San Miguel", "San Miguel");
        map.put("San Bernardo", "San Bernardo");
        map.put("San Ramón", "San Ramón");
        map.put("Santiago", "Santiago");
        map.put("Talagante", "Talagante");
        map.put("Tiltil", "Tiltil");
        map.put("Vitacura", "Vitacura");
        data.put("Región Metropolitana de Santiago", map);
    }
    
    public Map<String, Map<String, String>> getData() {
        return data;
    }
 
    public String getRegion() {
        return region;
    }
 
    public void setRegion(String region) {
        this.region = region;
    }
 
    public String getComuna() {
        return comuna;
    }
 
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public Map<String, String> getRegiones() {
        return regiones;
    }

    public void setRegiones(Map<String, String> regiones) {
        this.regiones = regiones;
    }

    public Map<String, String> getComunas() {
        return comunas;
    }

    public void setComunas(Map<String, String> comunas) {
        this.comunas = comunas;
    }
 
    
 
    public void cuandoSeCambiaLaRegion() {
        if(region !=null && !region.equals(""))
            comunas = data.get(region);
        else
            comunas = new HashMap<String, String>();
    }
    
}
