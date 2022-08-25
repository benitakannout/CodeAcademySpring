import HTTP from './axiosConfig';

const getQuestionsApi = () =>
    HTTP.get("/api/questions");

const getForumApi = () =>
    HTTP.get("/api/forum")

export {
    getQuestionsApi,
    getForumApi
}