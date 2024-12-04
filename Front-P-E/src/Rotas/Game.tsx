import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import '../Estilos/game.css';

const Game = () => {
  const [step, setStep] = useState(1);
  const [score, setScore] = useState(0);
  const [showFinalScore, setShowFinalScore] = useState(false);
  const navigate = useNavigate();

  const questions = [
    {
      question: `What is the color of the sky? ${" tradução: Qual a cor do céu?"}`,
      answers: ["Red", "Yellow", "White", "Blue"],
      correct: "Blue",
    },
    {
      question: `How many legs does a spider have? ${" tradução: Quantas pernas tem uma aranha?"}`,
      answers: ["two", "eight", "four", "six"],
      correct: "eight",
    },
    {
      question: `Which animal is known as the king of the jungle? ${" tradução: Qual animal é conhecido por ser o rei da selva?"}`,
      answers: ["Monkey", "Eagle", "Lion", "Snake"],
      correct: "Lion",
    },
  ];

  const handleAnswer = (answer: string) => {
    if (answer === questions[step - 1].correct) {
      setScore(score + 5);
    }
    if (step < questions.length) {
      setStep(step + 1);
    } else {
      setShowFinalScore(true);
    }
  };

  useEffect(() => {
    if (showFinalScore) {
      const timer = setTimeout(() => {
        navigate("/home");
      }, 2000);
      return () => clearTimeout(timer); 
    }
  }, [showFinalScore, navigate]);

  return (
    <div className="app-content">
        <div className="gametitle">
            <h1 className="titulo1">PacKids <br/> Nível 1</h1>
            <img className="pacgameimg" src="../public/imagens/pacman-beaneater.gif" alt="logo" />
        </div>
      
      <h2 className="pontuação">Score: {score}</h2>
      {showFinalScore ? (
        <div className="card-pontuação"
          
        >
          <h2>Nivel 1 concluído!</h2>
          <h3>Total de pontos: {score}</h3>
        </div>
      ) : step <= questions.length ? (
        <div className="perguntas-div">
          <h3 className="perguntas">{questions[step - 1].question}</h3>
          <div className="botoes-div">
            {questions[step - 1].answers.map((answer, index) => (
              <button
                key={index}
                onClick={() => handleAnswer(answer)}
                className="botoes-resposta"
              >
                {answer}
              </button>
            ))}
          </div>
        </div>
      ) : null}
    </div>
  );
};

export default Game;
