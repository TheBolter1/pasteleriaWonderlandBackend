package com.wonderland.backend.Configuration;

import com.wonderland.backend.Model.Producto;
import com.wonderland.backend.Model.User;
import com.wonderland.backend.Service.ProductoService;
import com.wonderland.backend.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductoService productoService;
    private final UserRepository userRepository;

    public DataLoader(ProductoService productoService, UserRepository userRepository) {
        this.productoService = productoService;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
     
        productoService.save(new Producto("TC001", 45000, "Torta Cuadrada de Chocolate",
                "/assets/img/Catalogo/tortas-cuadradas/cuadrada-chocolate.jpg",
                "Tortas Cuadradas",
                "Bizcocho de chocolate intenso elaborado con cacao puro y mantequilla natural. Su textura húmeda y su sabor profundo la hacen ideal para los amantes del chocolate. Perfecta para celebraciones o acompañar con café."));

        productoService.save(new Producto("TC002", 50000, "Torta Cuadrada de Frutas",
                "/assets/img/Catalogo/tortas-cuadradas/cuadrada-frutas.jpg",
                "Tortas Cuadradas",
                "Torta esponjosa con trozos de frutas naturales, equilibrada en dulzura y con aroma fresco. Ideal para quienes buscan un postre liviano y colorido, lleno de sabor y textura."));

        productoService.save(new Producto("TT001", 40000, "Torta Circular de Vainilla",
                "/assets/img/Catalogo/tortas-circulares/circular-vainilla.jpg",
                "Tortas Circulares",
                "Torta circular de vainilla preparada con ingredientes frescos y extracto natural de vainilla. Su masa suave y su cobertura cremosa hacen de este clásico una opción perfecta para cualquier ocasión."));

        productoService.save(new Producto("TT002", 42000, "Torta Circular de Manjar",
                "/assets/img/Catalogo/tortas-circulares/circular-manjar.jpeg",
                "Tortas Circulares",
                "Torta artesanal rellena con manjar y cubierta con un glaseado dorado. Combina el dulzor justo con una textura suave y ligera, ideal para compartir con familia y amigos."));

        productoService.save(new Producto("PI001", 5000, "Mousse de Chocolate",
                "/assets/img/Catalogo/postres-individuales/mousse-chocolate.jpg",
                "Postres Individuales",
                "Delicioso mousse con textura ligera y sabor profundo, elaborado con cacao 70%. Presentación individual ideal para catering o consumo personal."));

        productoService.save(new Producto("PI002", 5500, "Tiramisú Clásico",
                "/assets/img/Catalogo/postres-individuales/tiramisu.jpg",
                "Postres Individuales",
                "Nuestro tiramisú conserva la receta tradicional italiana, con capas de bizcocho empapado en café y crema de mascarpone, sin conservantes ni saborizantes artificiales."));

        productoService.save(new Producto("PSA001", 48000, "Torta Sin Azúcar de Naranja",
                "/assets/img/Catalogo/sin-azúcar/torta-naranja.jpg",
                "Productos Sin Azúcar",
                "Bizcocho húmedo endulzado con stevia, preparado con jugo natural de naranja. Ideal para personas que buscan opciones sin azúcar refinada sin renunciar al sabor."));

        productoService.save(new Producto("PSA002", 47000, "Cheesecake Sin Azúcar",
                "/assets/img/Catalogo/sin-azúcar/cheesecake.jpg",
                "Productos Sin Azúcar",
                "Endulzado naturalmente, nuestro Cheesecake sin azúcar ofrece un equilibrio entre suavidad y frescura, perfecto para quienes cuidan su alimentación."));

        productoService.save(new Producto("PT001", 3000, "Empanada de Manzana",
                "/assets/img/Catalogo/tradicional/empanada-manzana.jpg",
                "Pastelería Tradicional",
                "Receta tradicional con trozos de manzana caramelizada y canela. Ideal para acompañar con té o café."));

        productoService.save(new Producto("PT002", 6000, "Tarta de Santiago",
                "/assets/img/Catalogo/tradicional/tarta-santiago.jpg",
                "Pastelería Tradicional",
                "La auténtica Tarta de Santiago, elaborada con harina de almendra, sin gluten y con sabor a tradición española."));

        productoService.save(new Producto("PG001", 4000, "Brownie Sin Gluten",
                "/assets/img/Catalogo/sin-gluten/brownie.webp",
                "Productos Sin Gluten",
                "Textura húmeda y sabor profundo. Hecho con harina de almendras, sin gluten ni conservantes, apto para celíacos."));

        productoService.save(new Producto("PG002", 3500, "Pan Sin Gluten",
                "/assets/img/Catalogo/sin-gluten/pan.webp",
                "Productos Sin Gluten",
                "Elaborado con mezcla de harinas naturales sin trigo. Perfecto para quienes buscan una dieta libre de gluten."));

        productoService.save(new Producto("PV001", 50000, "Torta Vegana de Chocolate",
                "/assets/img/Catalogo/vegano/torta-chocolate.jpg",
                "Productos Veganos",
                "Elaborada con cacao puro y aceite vegetal. Su textura húmeda y sabor intenso la convierten en la favorita del catálogo vegano."));

        productoService.save(new Producto("PV002", 4500, "Galletas Veganas de Avena",
                "/assets/img/Catalogo/vegano/galletas-avena.jpg",
                "Productos Veganos",
                "Crujientes por fuera y suaves por dentro. Una opción nutritiva, libre de ingredientes de origen animal."));

        productoService.save(new Producto("TE001", 55000, "Torta Especial de Cumpleaños",
                "/assets/img/Catalogo/tortas-especiales/torta-cumpleanos.jpg",
                "Tortas Especiales",
                "Personalizable con mensajes o decoraciones. Bizcocho suave, relleno a elección y cobertura cremosa."));

        productoService.save(new Producto("TE002", 60000, "Torta Especial de Boda",
                "/assets/img/Catalogo/tortas-especiales/torta-boda.webp",
                "Tortas Especiales",
                "Hecha por encargo, con diseños personalizados. Sabor delicado, decoración premium y presentación impecable."));

        
        if (userRepository.count() == 0) {
            User admin = new User();
            admin.setCorreo("admin@wonderland.com");
            admin.setPasswordHash("admin123"); 
            admin.setRol("ADMIN");
            admin.setRut("11111111-1");
            admin.setNombres("Felipe");
            admin.setApellidos("Administrador");
            admin.setFechaRegistro(new Date());

            User cliente = new User();
            cliente.setCorreo("cliente@wonderland.com");
            cliente.setPasswordHash("cliente123"); 
            cliente.setRol("CLIENTE");
            cliente.setRut("22222222-2");
            cliente.setNombres("Juan");
            cliente.setApellidos("Cliente");
            cliente.setFechaRegistro(new Date());

            userRepository.save(admin);
            userRepository.save(cliente);
        }
    }
}
