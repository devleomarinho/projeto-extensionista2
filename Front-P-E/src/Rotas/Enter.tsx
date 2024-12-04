import { Link } from 'react-router-dom';
import '../Estilos/Enter.css'


//Rota de entrada do App
export const Enter = () => {
  return (
    <div className='app-content'>
        <main>
            <div className="image-box">
                <img src="../public/imagens/logo-packids.png" alt="Pac Kids Logo" />
            </div>
            <p className="subtitle">Let’s start your English adventure <br/> today. Learning English is fun!</p>
        </main>
        <section>
            <Link to='/register' className="button button-primary" type="button">COMEÇAR AGORA</Link>
            <Link to='/login' className="button button-secondary" type="button">JÁ TENHO CONTA</Link>
        </section>
    </div>
  )
}

export default Enter;
