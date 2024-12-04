import  { useState } from "react";
import { useNavigate } from "react-router-dom";
import '../Estilos/register.css'

const Register = () => {
    const [step, setStep] = useState(1);
    const [showModal, setShowModal] = useState(false);
    const navigate = useNavigate();

    const handleNext = () => {
        setStep(2); // Vai para a próxima etapa
    };

    const handleBack = () => {
        setStep(1); // Volta para a etapa anterior
    };
    const handleSubmit = (e) => {
        e.preventDefault();

        // Exibir o modal de sucesso
        setShowModal(true);

        //Após um breve intervalo, redirecionar para /login
        setTimeout(() => {
            setShowModal(false); // Fecha o modal
            navigate("/login"); // Redireciona para a rota /login
        }, 2000); // 2 segundos para o usuário ver o modal
    };
    return (
        <div className="app-content">
            <div className="image-boxl">
                <img src="../public/imagens/logo-packids.png" alt="Pac Kids Logo" />
            </div>
            <div className="">
                <form className="form-container" onSubmit={handleSubmit}>
                    {step === 1 && (
                        <>
                            <h2>Informações Pessoais</h2>
                            <label htmlFor="fullName">Nome Completo:</label>
                            <input
                                type="text"
                                id="fullName"
                                name="fullName"
                                required
                                placeholder="Digite seu nome completo"
                            />

                            <label htmlFor="phone">Telefone:</label>
                            <input
                                type="tel"
                                id="phone"
                                name="phone"
                                required
                                placeholder="Digite seu telefone"
                            />

                            <label htmlFor="cpf">CPF:</label>
                            <input
                                type="text"
                                id="cpf"
                                name="cpf"
                                required
                                placeholder="Digite seu CPF"
                            />

                            <label htmlFor="birthdate">Data de nascimento:</label>
                            <input
                                type="date"
                                id="birthdate"
                                name="birthdate"
                                required
                            />

                            <button type="button" className="button button-primary" onClick={handleNext}>
                                Próximo
                            </button>
                        </>
                    )}

                    {step === 2 && (
                        <>
                            <h2>Informações de Login</h2>
                            <label htmlFor="email">Email:</label>
                            <input
                                type="email"
                                id="email"
                                name="email"
                                required
                                placeholder="Digite seu email"
                            />

                            <label htmlFor="password">Senha:</label>
                            <input
                                type="password"
                                id="password"
                                name="password"
                                required
                                placeholder="Digite sua senha"
                            />

                            <label htmlFor="confirmPassword">Confirmação de senha:</label>
                            <input
                                type="password"
                                id="confirmPassword"
                                name="confirmPassword"
                                required
                                placeholder="Confirme sua senha"
                            />

                            <button type="button" className="button button-secondary" onClick={handleBack}>
                                Voltar
                            </button>
                            <button type="submit" className="button button-primary">Enviar</button>
                        </>
                    )}
                </form>
            </div>
            {/* Modal de sucesso */}
            {showModal && (
                <div className="modal">
                    <div className="modal-content">
                        <img className="checked-img" src="../public/icons/checked-2.svg" />
                        <h3>Cadastro realizado com sucesso!</h3>
                        <p>Você será redirecionado para a página de login.</p>
                    </div>
                </div>
            )}
        </div>
    )
}

export default Register;
