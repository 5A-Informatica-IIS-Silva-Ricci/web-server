export default {
    /**
     * Utilizza delle api per la geolocalizzazione per ottenere dall'indirizzo IP il luogo e l'ora dell'utente.
     * Se fallisce ritorna null.
     * @returns {Object|null}
     */
    async getGeolocation() {
        // return { timezone: { current_time: '18:47:10' }}
        // Axios è una libreria che permette di fare richieste http in modo più rapido e comodo
        const [err, data] = await this.getResult(axios.get("https://ipgeolocation.abstractapi.com/v1/?api_key=e4773f295a3d46a69cebcaf8789dd401"))
        if (err)
            return null
        else
            return data.data
    },

    /**
     * Converte un orario in un messaggio di benvenuto a seconda di esso.
     * @param current_time il tempo all'interno della risposta ottenuta da {@link getGeolocation}
     * @returns {string} Un messaggio di benvenuto (Buongiorno, Buon pomeriggio, Buonasera)
     */
    getMessaggioIntro(current_time) {
        const currentTimeInt = parseInt(current_time.substring(0, 2))

        let messaggioIntro;

        if (currentTimeInt > 6 && currentTimeInt < 13)
            messaggioIntro = "Buongiorno"
        else if (currentTimeInt < 18)
            messaggioIntro = "Buon pomeriggio"
        else
            messaggioIntro = "Buonasera"

        return messaggioIntro
    },

    /**
     * Gestisce una qualsiasi promise in modo da ritornare sempre un array con in prima posizione l'errore se esistente ed in seconda il risultato della promise.
     * @param promise la promise da gestire
     * @returns {promise<Array.<Object|null, Object|null>>}
     */
    getResult(promise) {
        return promise.then(data => [null, data])
            .catch(err => [err]);
    }
}
