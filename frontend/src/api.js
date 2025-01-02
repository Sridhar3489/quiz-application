import axios from "axios";

const API_BASE_URL = "http://localhost:8002/api/quizzes";

export const fetchAllQuizzes = async () => {
    const response = await axios.get(`${API_BASE_URL}`);
    return response.data;
};

export const fetchQuizById = async (id) => {
    const response = await axios.get(`${API_BASE_URL}/${id}`);
    return response.data;
};

export const generateQuizQuestions = async (topic) => {
    const response = await axios.post(
        `${API_BASE_URL}/generate-question`,
        null,
        { params: { topic } }
    );
    return response.data;
};

export const createQuiz = async (quiz) => {
    const response = await axios.post(`${API_BASE_URL}/quizzes`, quiz);
    return response.data;
};

export const addQuestionToQuiz = async (quizId, question) => {
    const response = await axios.post(
        `${API_BASE_URL}/${quizId}/questions`,
        question
    );
    return response.data;
};
