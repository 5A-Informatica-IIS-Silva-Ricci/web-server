export default {
    async getGeolocation() {
        return { timezone: { current_time: '18:47:10' }}
        const [err, data] = await this.getResult(axios.get("https://ipgeolocation.abstractapi.com/v1/?api_key=e4773f295a3d46a69cebcaf8789dd401"))
        if (err)
            return null
        else
            return data.data
    },

    getResult(promise) {
        return promise.then(data => [null, data])
            .catch(err => [err]);
    }
}
