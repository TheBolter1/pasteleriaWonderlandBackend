package com.wonderland.backend.Configuration;

import com.wonderland.backend.Model.Producto;
import com.wonderland.backend.Model.User;
import com.wonderland.backend.Model.Empleado;
import com.wonderland.backend.Model.Mensaje;
import com.wonderland.backend.Service.ProductoService;
import com.wonderland.backend.Repository.UserRepository;
import com.wonderland.backend.Repository.EmpleadoRepository;
import com.wonderland.backend.Repository.MensajeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductoService productoService;
    private final UserRepository userRepository;
    private final MensajeRepository mensajeRepository;
    private final EmpleadoRepository empleadoRepository;

    public DataLoader(
            ProductoService productoService,
            UserRepository userRepository,
            MensajeRepository mensajeRepository,
            EmpleadoRepository empleadoRepository
    ) {
        this.productoService = productoService;
        this.userRepository = userRepository;
        this.mensajeRepository = mensajeRepository;
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // ================== PRODUCTOS ==================
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
        if (mensajeRepository.count() == 0) {
            Mensaje m1 = new Mensaje();
            m1.setFecha("2025-11-30");
            m1.setNombre("Torta de matrimonio");
            m1.setCorreo("fran@duocuc.cl");
            m1.setOrden("-");
            m1.setMensaje(
                    "Necesitamos una torta de boda muy grande, de tres pisos, con decoración elegante y flores comestibles. " +
                    "El evento será el 15 de diciembre y necesitamos que la entrega sea puntual en la iglesia central. " +
                    "Además, queremos que tenga sabor vainilla con relleno de frambuesa en todos los pisos. " +
                    "Por favor, confirmen disponibilidad y precio."
            );

            Mensaje m2 = new Mensaje();
            m2.setFecha("2025-11-30");
            m2.setNombre("Cotización coffee break empresa");
            m2.setCorreo("recursos.fills@empresa.cl");
            m2.setOrden("-");
            m2.setMensaje(
                    "Holaaaa, queremos cotizar un servicio de coffee break para 40 personas, con opciones dulces y saladas. " +
                    "La actividad sería un viernes en la mañana, en Providencia. Por favor " +
                    "enviar valores por persona y condiciones de entrega."
            );

            mensajeRepository.save(m1);
            mensajeRepository.save(m2);
        }

 
        empleadoRepository.deleteAll();

        Empleado e1 = new Empleado();
        e1.setRut("12345678-9");
        e1.setDv("9");
        e1.setNombres("Taylor Alisson");
        e1.setApellidos("Swift Swift");
        e1.setCorreo("taylor@wonderland.com");
        e1.setTelefono("+56911111111");
        e1.setCargo("Pastelera");
        e1.setDireccion("Irarrázaval 123");
        e1.setFecha_nacimiento("1989-05-10");

        Empleado e2 = new Empleado();
        e2.setRut("98765432-1");
        e2.setDv("1");
        e2.setNombres("Ariadna Maria");
        e2.setApellidos("Jade Jerez");
        e2.setCorreo("ariadna@wonderland.com");
        e2.setTelefono("+56922222222");
        e2.setCargo("Mesera");
        e2.setDireccion("Parque O'Higgins 456");
        e2.setFecha_nacimiento("1988-11-20");

        empleadoRepository.save(e1);
        empleadoRepository.save(e2);
    }

}
