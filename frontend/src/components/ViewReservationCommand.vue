<template>
    <v-card outlined>
        <v-card-title>
            ViewReservation
        </v-card-title>

        <v-card-text>
            <String label="Name" v-model="value.name" :editMode="editMode"/>
            <String label="Location" v-model="value.location" :editMode="editMode"/>
            <String label="RoomTypes" v-model="value.roomTypes" :editMode="editMode"/>
            <roomTypesType offline label="RoomTypesType" v-model="value.roomTypesType" :editMode="editMode" @change="change"/>
            <Date label="AvailableDates" v-model="value.availableDates" :editMode="editMode"/>
            <Money offline label="Price" v-model="value.price" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="viewReservation"
            >
                ViewReservation
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'ViewReservationCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.name = '';
            this.value.location = '';
            this.value.roomTypes = [];
            this.value.roomTypesType = {};
            this.value.availableDates = [];
            this.value.price = {};
        },
        watch: {
        },
        methods: {
            viewReservation() {
                this.$emit('viewReservation', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

